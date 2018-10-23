package com.hospital.web;

import com.hospital.entity.*;
import com.hospital.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.applet.Main;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    private AccountService accountService;

    @Autowired
    private AlarmService alarmService;

    @RequestMapping("home")
    private String home(Model model) {
        List<ElderUser> elderUsers = elderUserService.getAllElderUser();
        Map<Integer, Integer> elderAgeMap = new TreeMap<>();

        List<DoctorUser> doctorUserList = doctorUserService.getAllDoctors();
        List<Integer> doctorGender = new ArrayList<>();
        doctorGender.add(0, 0);
        doctorGender.add(1, 0);

        for (ElderUser user : elderUsers) {
            int key = user.getAge();
            if (elderAgeMap.containsKey(key)) {
                elderAgeMap.put(key, elderAgeMap.get(key) + 1);
            } else {
                elderAgeMap.put(key, 1);
            }
        }

        for (DoctorUser user : doctorUserList) {
            doctorGender.set(user.getGenderInt(), doctorGender.get(user.getGenderInt()) + 1);
        }

        List<MainMenu> menuList = menuService.getMenu(MenuService.SYSTEM_MENU, "", "");
        model.addAttribute("menuList", menuList);
        model.addAttribute("data", elderAgeMap);
        model.addAttribute("gender", doctorGender);
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

    @RequestMapping("stat")
    private String stat(Model model) {

        List<Account> users = accountService.getAllUser();
        Map<String, Integer> data = new TreeMap<>();
        for (Account account : users) {
            String key = account.getCreatedAt().substring(0, 7);
            if (data.containsKey(key)) {
                data.put(key, data.get(key) + 1);
            } else {
                data.put(key, 1);
            }
        }
        List<MainMenu> menuList = menuService.getMenu(MenuService.SYSTEM_MENU, "档案管理", "基础数据统计");
        model.addAttribute("menuList", menuList);
        model.addAttribute("data", data);

        return "system/stat";
    }

}
