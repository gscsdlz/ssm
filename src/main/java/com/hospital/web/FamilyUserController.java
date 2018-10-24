package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.dto.DynamicTableViewResponse;
import com.hospital.dto.NormalResponse;
import com.hospital.entity.*;
import com.hospital.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private FamilyUserService familyUserService;

    @RequestMapping("me")
    private String me(Model model) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        FamilyUser user = familyUserService.getFamilyUser(accountId);
        List<MainMenu> menuList = menuService.getMenu(MenuService.FAMILY_MENU, "", "");
        model.addAttribute("user", user);
        model.addAttribute("menuList", menuList);
        return "family/user";
    }

    @RequestMapping("/home")
    private String home(Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.FAMILY_MENU, "", "");
        model.addAttribute("menuList", menuList);
        return "family/index";
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

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String update(@RequestParam Map<String, String> param) {
        String info = param.get("json");
        ObjectMapper mapper = new ObjectMapper();
        FamilyUser user = null;
        try {
            user = mapper.readValue(info, FamilyUser.class);
            int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
            user.setAccountId(accountId);
            familyUserService.updateUser(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }

    @ResponseBody
    @RequestMapping(value = "get_data", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    private String getAlarmData() {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        List<Alarm> list = alarmService.getAlarmByFamily(accountId);
        DynamicTableViewResponse<List<Alarm>> response = new DynamicTableViewResponse<>();
        response.setStatus(true);

        response.setData(list);
        return response.toString();
    }

    @ResponseBody
    @RequestMapping(value = "get_user_data", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    private String getUserData() {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        List<ElderUser> list = followService.getHomeElders(accountId);
        DynamicTableViewResponse<List<ElderUser>> response = new DynamicTableViewResponse<>();
        response.setStatus(true);

        response.setData(list);
        return response.toString();
    }
}
