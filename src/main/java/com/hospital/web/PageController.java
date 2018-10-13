package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.*;
import com.hospital.service.HealthDataService;
import com.hospital.service.MenuService;
import com.hospital.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private HealthDataService healthDataService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/home")
    private String index(Model model) {
        switch (Integer.parseInt(request.getSession().getAttribute("act").toString())) {
            case Account.ELDER_USER:
                return "redirect:/elder_user/home";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping("/")
    private String index() {
        System.out.println(request.getSession().getAttribute("username"));
        System.out.println(request.getSession().getAttribute("account_id"));
        System.out.println(request.getSession().getAttribute("act"));
        return "home/index";
    }

    @RequestMapping("/login")
    private String login() {
        if (request.getSession().getAttribute("account_id") == null)
            return "home/login";
        else
            return "redirect:/home";
    }
}
