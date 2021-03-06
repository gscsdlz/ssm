package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.dto.NormalResponse;
import com.hospital.entity.*;
import com.hospital.service.AlarmService;
import com.hospital.service.MenuService;
import com.hospital.service.PositionService;
import com.hospital.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private HttpServletRequest request;

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

        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());

        Position p = positionService.getPosition(accountId, date);

        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "健康监护", "地图定位");
        model.addAttribute("menuList", menuList);
        model.addAttribute("position", p);
        return "elder/position";
    }

    @RequestMapping("/warning_set")
    //具体方法使用AJAX在WarningSetController中
    private String warningSet(@RequestParam Map<String, Object> param, Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "健康监护", "预警设置");
        model.addAttribute("menuList", menuList);
        return "elder/warning_set";
    }

    @RequestMapping("alarm_show")
    private String alarmShow(@RequestParam Map<String, Object> param, Model model) {

        int handle = 0;
        try {
            handle = Integer.parseInt(param.get("handle").toString());
        } catch (Exception e) {

        }
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        List<Alarm> list = alarmService.getAlarm(accountId, handle);
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "健康监护", "异常指标");
        model.addAttribute("menuList", menuList);
        model.addAttribute("data", list);
        model.addAttribute("handle", handle);
        model.addAttribute("keyNameMap", Warning.keyNames);
        return "elder/alarm_show";
    }

    @ResponseBody
    @RequestMapping(value = "do_handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String doHandle(@RequestParam Map<String, Object> param) {
        int alarmId = Integer.parseInt(param.get("alarmId").toString());
        int handle = Alarm.ALARM_HANDLE;
        alarmService.doHandle(alarmId, handle);

        NormalResponse response = new NormalResponse();
        response.setStatus(true);

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(response);
        } catch (Exception e) {
            return "";
        }

    }
}
