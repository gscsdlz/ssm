package com.hospital.web;

import com.hospital.entity.DoctorUser;
import com.hospital.entity.MainMenu;
import com.hospital.service.DoctorUserService;
import com.hospital.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("doctor_user")
public class DoctorUserController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private DoctorUserService doctorUserService;

    @RequestMapping("me")
    private String me(Model model) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        DoctorUser user = doctorUserService.getDoctorUser(accountId);
        List<MainMenu> menuList = menuService.getMenu(MenuService.DOCTOR_MENU, "", "");

        model.addAttribute("user", user);
        model.addAttribute("menuList", menuList);
        return "doctor/user";
    }
}
