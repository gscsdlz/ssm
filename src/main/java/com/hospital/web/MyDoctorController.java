package com.hospital.web;

import com.hospital.dto.NormalResponse;
import com.hospital.entity.DoctorUser;
import com.hospital.entity.MainMenu;
import com.hospital.service.ConnectionService;
import com.hospital.service.DoctorUserService;
import com.hospital.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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

    @RequestMapping("show")
    private String show(Model model) {

        List<DoctorUser> doctorUserList = doctorUserService.getAllDoctors();
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "", "");
        model.addAttribute("menuList", menuList);
        model.addAttribute("data", doctorUserList);
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
    @RequestMapping(value = "remove_connection", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String removeConnection(@RequestParam Map<String, String> param) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        int doctorId = Integer.parseInt(param.get("doctor_id"));

        connectionService.removeConnection(accountId, doctorId);

        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }

}
