package com.hospital.web;

import com.hospital.dto.NormalResponse;
import com.hospital.entity.*;
import com.hospital.service.ConnectionService;
import com.hospital.service.DoctorUserService;
import com.hospital.service.MenuService;
import com.hospital.service.QAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("doctor_user")
public class DoctorUserController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private QAService qaService;

    @Autowired
    private DoctorUserService doctorUserService;

    @Autowired
    private ConnectionService connectionService;

    @RequestMapping("me")
    private String me(Model model) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        DoctorUser user = doctorUserService.getDoctorUser(accountId);
        List<MainMenu> menuList = menuService.getMenu(MenuService.DOCTOR_MENU, "", "");

        model.addAttribute("user", user);
        model.addAttribute("menuList", menuList);
        return "doctor/user";
    }

    @RequestMapping("question")
    private String myQuestion(Model model) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        List<Question> questions = qaService.getQuestionsByDoctorId(accountId);
        List<MainMenu> menuList = menuService.getMenu(MenuService.DOCTOR_MENU, "咨询问题", "查看详情");
        List<ElderUser> elderUsers = connectionService.getMyElders(accountId);
        model.addAttribute("menuList", menuList);
        model.addAttribute("data", questions);
        model.addAttribute("elders", elderUsers);
        return "doctor/my_question";
    }

    @ResponseBody
    @RequestMapping(value = "unconnection", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String removeConnection(@RequestParam Map<String, String> param) {
        int doctorId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        int accountId = Integer.parseInt(param.get("elder_id"));

        connectionService.removeConnection(accountId, doctorId);
        qaService.removeQAByUId(accountId, doctorId);
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }

    @RequestMapping("chat")
    private String chat(@RequestParam Map<String, String> param,  Model model) {

        int questionId = Integer.parseInt(param.get("question_id"));
        Question question = qaService.getQuestion(questionId);
        List<Answer> answers = qaService.getAnswers(questionId);
        List<MainMenu> menuList = menuService.getMenu(MenuService.DOCTOR_MENU, "咨询问题", "查看详情");

        model.addAttribute("question", question);
        model.addAttribute("answers", answers);
        model.addAttribute("act", Integer.parseInt(request.getSession().getAttribute("act").toString()));
        model.addAttribute("menuList", menuList);
        return "/chat";
    }

    @RequestMapping("evaluate")
    private String evaluate(@RequestParam Map<String, String> param, Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.DOCTOR_MENU, "", "");
        model.addAttribute("menuList", menuList);
        return "doctor/evaluate";
    }
}
