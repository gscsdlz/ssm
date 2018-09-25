package com.hospital.web;

import com.hospital.entity.*;
import com.hospital.service.AlarmService;
import com.hospital.service.MenuService;
import com.hospital.service.PositionService;
import com.hospital.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/health_monitor")
public class HealthMonitorController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private AlarmService alarmService;

    @RequestMapping("/position")
    private String position(@RequestParam Map<String, Object> param, Model model) {

        String date;
        try {
            date = param.get("date").toString();
        } catch (Exception e) {
            Calendar now = Calendar.getInstance();
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            date = ft.format(now.getTime());
        }

        //TODO 测试用Session
        Position p = positionService.getPosition(1, date);

        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU);
        model.addAttribute("menuList", menuList);
        model.addAttribute("position", p);
        return "elder/position";
    }

    @RequestMapping("/warning_set")
    //具体方法使用AJAX在WarningSetController中
    private String warningSet(@RequestParam Map<String, Object> param, Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU);
        model.addAttribute("menuList", menuList);
        return "elder/warning_set";
    }

    @RequestMapping("warning_look")
    private String warningLook(@RequestParam Map<String, Object> param, Model model) {

        //TODO 测试Session
        List<Alarm> list = alarmService.getAlarm(1, Alarm.ALARM_UNHANDLE);

        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU);
        model.addAttribute("menuList", menuList);
        model.addAttribute("data", list);
        return "elder/warning_look";
    }
}
