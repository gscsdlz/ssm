package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.*;
import com.hospital.service.*;
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

    @Autowired
    private DoctorUserService doctorUserService;

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private WorkOrderService workOrderService;

    @RequestMapping("/home")
    private String home(Model model) {
        switch (Integer.parseInt(request.getSession().getAttribute("act").toString())) {
            case Account.ELDER_USER:
                return "redirect:/elder_user/home";
            case Account.DOCTOR_USER:
                return "redirect:/doctor_user/home";
            case Account.FAMILY_USER:
                return "redirect:/family_user/home";
            case Account.GROUP_USER:
                return "redirect:/group_user/home";
            case Account.SYSTEM_USER:
                return "redirect:/system_user/home";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping("/")
    private String index(Model model) {
        model.addAttribute("doctors", doctorUserService.getAllDoctors().size());
        model.addAttribute("complaints", complaintService.getAllComplaint().size());
        model.addAttribute("healthData", healthDataService.countAllHealthData());
        model.addAttribute("workOrders", workOrderService.getAll().size());
        model.addAttribute("menu", 1);
        return "home/index";
    }

    @RequestMapping("/login")
    private String login() {
        if (request.getSession().getAttribute("account_id") == null)
            return "home/login";
        else
            return "redirect:/home";
    }

    @RequestMapping("/page/services")
    private String services(Model model) {
        model.addAttribute("menu", 2);
        return "home/services";
    }

    @RequestMapping("/page/about")
    private String about(Model model) {
        model.addAttribute("menu", 3);
        return "home/about";
    }

    @RequestMapping("/page/contact")
    private String contact(Model model) {
        model.addAttribute("menu", 4);
        return "home/contact";
    }
}
