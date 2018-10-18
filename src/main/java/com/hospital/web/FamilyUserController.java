package com.hospital.web;

import com.hospital.entity.*;
import com.hospital.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("family_user")
public class FamilyUserController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FollowService followService;

    @Autowired
    private AlarmService alarmService;

    @Autowired
    private ElderUserService elderUserService;

    @Autowired
    private PositionService positionService;

    private String me() {
        return "";
    }

    private String home() {
        return "";
    }

    @RequestMapping("record")
    private String elderRecord(Model model) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        List<ElderUser> list = followService.getHomeElders(accountId);
        List<MainMenu> menuList = menuService.getMenu(MenuService.FAMILY_MENU, "老人信息", "亲人档案");

        model.addAttribute("elders", list);
        model.addAttribute("menuList", menuList);
        return "family/record";
    }

    @RequestMapping("alarm")
    private String elderAlarm(@RequestParam Map<String, String> param, Model model) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        List<ElderUser> list = followService.getHomeElders(accountId);
        List<MainMenu> menuList = menuService.getMenu(MenuService.FAMILY_MENU, "告警信息", "异常指标信息");

        int elderId = 0;
        try {
            elderId = Integer.parseInt(param.get("id"));
        } catch (Exception e) {

        }
        List<Alarm> alarms = alarmService.getAlarm(elderId, Alarm.ALARM_UNHANDLE);
        List<ElderUser> elderUsers = new ArrayList<>();
        for (Alarm a : alarms) {
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
        model.addAttribute("alarms", alarms);
        model.addAttribute("elderUsers", elderUsers);
        model.addAttribute("keyNameMap", Warning.keyNames);

        return "family/warning";
    }

    @RequestMapping("position")
    private String elderPosition(@RequestParam Map<String, String> param, Model model) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        List<ElderUser> list = followService.getHomeElders(accountId);
        List<MainMenu> menuList = menuService.getMenu(MenuService.FAMILY_MENU, "地图定位", "老人定位");

        int elderId = 0;
        try {
            elderId = Integer.parseInt(param.get("id"));
        } catch (Exception e) {

        }
        Position pos = positionService.queryLastPosition(elderId);

        model.addAttribute("position", pos);
        model.addAttribute("elders", list);
        model.addAttribute("menuList", menuList);
        return "family/position";
    }
}
