package com.hospital.web;

import com.hospital.service.DoctorUserService;
import com.hospital.service.ElderUserService;
import com.hospital.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("system_user")
public class SystemUserController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MenuService menuService;

    @Autowired
    private ElderUserService elderUserService;

    @Autowired
    private DoctorUserService doctorUserService;

    @RequestMapping("index")
    private String home(Model model) {
        return "system/index";
    }

}
