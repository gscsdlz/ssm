package com.hospital.web;

import com.hospital.entity.DoctorUser;
import com.hospital.entity.ElderUser;
import com.hospital.entity.MainMenu;
import com.hospital.service.ConnectionService;
import com.hospital.service.DoctorUserService;
import com.hospital.service.ElderUserService;
import com.hospital.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user_manage")
public class UserManageController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MenuService menuService;

    @Autowired
    private ElderUserService elderUserService;

    @Autowired
    private DoctorUserService doctorUserService;

    @Autowired
    private ConnectionService connectionService;

    @RequestMapping("elder")
    private String elderShow(@RequestParam Map<String, String> param, Model model) {
        int elderId = 0;
        try {
            elderId = Integer.parseInt(param.get("id"));
        } catch (Exception e) {
            ;
        }
        ElderUser user = elderUserService.getElderUser(elderId);
        List<DoctorUser> doctors = connectionService.getMyDoctors(elderId);
        List<MainMenu> menuList = menuService.getMenu(MenuService.GROUP_MENU, "" ,"");
        List<ElderUser> elderUsers = elderUserService.getAllElderUser();
        model.addAttribute("elders", elderUsers);
        model.addAttribute("user", user);
        model.addAttribute("doctors", doctors);
        model.addAttribute("menuList", menuList);
        return "group/elder";
    }

    @RequestMapping("doctor")
    private String doctorShow(@RequestParam Map<String, String> param, Model model) {
        int doctorId = 0;
        try {
            doctorId = Integer.parseInt(param.get("id"));
        } catch (Exception e) {
            ;
        }
        DoctorUser user = doctorUserService.getDoctorUser(doctorId);
        List<ElderUser> elders = connectionService.getMyElders(doctorId);
        List<MainMenu> menuList = menuService.getMenu(MenuService.GROUP_MENU, "" ,"");
        List<DoctorUser> doctorUserList = doctorUserService.getAllDoctors();
        model.addAttribute("user", user);
        model.addAttribute("elders", elders);
        model.addAttribute("doctors", doctorUserList);
        model.addAttribute("menuList", menuList);
        return "group/doctor";
    }
}
