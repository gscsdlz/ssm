package com.hospital.web;

import com.hospital.entity.Alarm;
import com.hospital.entity.ElderUser;
import com.hospital.entity.MainMenu;
import com.hospital.entity.Warning;
import com.hospital.service.AlarmService;
import com.hospital.service.DoctorUserService;
import com.hospital.service.ElderUserService;
import com.hospital.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private AlarmService alarmService;

    @RequestMapping("home")
    private String home(Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.SYSTEM_MENU, "", "");
        model.addAttribute("menuList", menuList);
        return "system/index";
    }

    @RequestMapping("alarm")
    private String alarmShow(Model model) {
        List<Alarm> list = alarmService.getAllAlarm();
        List<ElderUser> elderUsers = new ArrayList<>();
        List<MainMenu> menuList = menuService.getMenu(MenuService.SYSTEM_MENU, "个体预警" , "查看详情");
        for (Alarm a : list) {
            boolean find = false;
            for(ElderUser user : elderUsers) {
                if (user.getAccountId() == a.getAccountId()) {
                    find = true;
                    break;
                }
            }
            if(!find)
                elderUsers.add(elderUserService.getElderUser(a.getAccountId()));
        }

        model.addAttribute("elders", list);
        model.addAttribute("menuList", menuList);
        model.addAttribute("alarms", list);
        model.addAttribute("elderUsers", elderUsers);
        model.addAttribute("keyNameMap", Warning.keyNames);
        return "group/index";
    }

}
