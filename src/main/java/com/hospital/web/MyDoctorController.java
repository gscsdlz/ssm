package com.hospital.web;

import com.hospital.dto.NormalResponse;
import com.hospital.entity.Answer;
import com.hospital.entity.DoctorUser;
import com.hospital.entity.MainMenu;
import com.hospital.entity.Question;
import com.hospital.service.ConnectionService;
import com.hospital.service.DoctorUserService;
import com.hospital.service.MenuService;
import com.hospital.service.QAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.rmi.server.RMIClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("my_doctor")
public class MyDoctorController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private DoctorUserService doctorUserService;

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private QAService qaService;

    @RequestMapping("show")
    private String show(@RequestParam Map<String, String> param, Model model) {
        String name = param.get("realname") == null ? "" : param.get("realname");
        String phone = param.get("phone") == null ? "" : param.get("phone");

        List<DoctorUser> doctorUserList = doctorUserService.getAllDoctors();

        List<DoctorUser> res = new ArrayList<>();
        if (name.length() == 0 && phone.length() == 0) {
            System.out.println("ok");
            res = doctorUserList;
        } else {
            for (DoctorUser user : doctorUserList) {
                if ((user.getRealname().contains(name) && !name.isEmpty()) || (user.getPhone().contains(phone) && !phone.isEmpty())) {
                    res.add(user);
                }
            }
        }

        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "家庭医生", "医生专家库");

        model.addAttribute("phone", phone);
        model.addAttribute("realname", name);
        model.addAttribute("menuList", menuList);
        model.addAttribute("data", res);
        return "elder/doctor_list";
    }

    @ResponseBody
    @RequestMapping(value = "add_connection", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String addConnection(@RequestParam Map<String, String> param) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        int doctorId = Integer.parseInt(param.get("doctor_id"));
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        try {
            connectionService.addConnection(accountId, doctorId);
        } catch (DuplicateKeyException e) {
            response.setStatus(false);
            response.setInfo("已经关注当前医生");
        }
        return response.toString();
    }

    @ResponseBody
    @RequestMapping(value = "unconnection", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String removeConnection(@RequestParam Map<String, String> param) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        int doctorId = Integer.parseInt(param.get("doctor_id"));

        connectionService.removeConnection(accountId, doctorId);
        qaService.removeQAByUId(accountId, doctorId);
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }

    @RequestMapping("my_question")
    private String myQuestion(Model model) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());

        List<Question> list = qaService.getQuestionsByElderId(accountId);
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "家庭医生", "我的咨询");
        List<DoctorUser> doctors = connectionService.getMyDoctors(accountId);

        model.addAttribute("data", list);
        model.addAttribute("doctors", doctors);
        model.addAttribute("menuList", menuList);
        model.addAttribute("list", list);
        return "elder/my_question";
    }

    @RequestMapping("chat")
    private String chat(@RequestParam Map<String, String> param,  Model model) {

        int questionId = Integer.parseInt(param.get("question_id"));
        Question question = qaService.getQuestion(questionId);
        List<Answer> answers = qaService.getAnswers(questionId);
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "家庭医生", "我的咨询");

        model.addAttribute("question", question);
        model.addAttribute("answers", answers);
        model.addAttribute("act", Integer.parseInt(request.getSession().getAttribute("act").toString()));
        model.addAttribute("menuList", menuList);
        return "/chat";
    }

}
