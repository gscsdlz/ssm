package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.*;
import com.hospital.service.HealthDataService;
import com.hospital.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("health_data")
public class HealthDataController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private HealthDataService healthDataService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/blood_pressure")
    private String bloodPressure(@RequestParam Map<String, Object> param, Model model) {
        List<HealthData> healthData;
        List<String> date = handleDefaultDate(param);
        String lDate = date.get(0);
        String rDate = date.get(1);
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        healthData = healthDataService.getHealthDataByDate(HealthData.HTYPE_BLOOD_PRESSURE, accountId, lDate, rDate);

        ObjectMapper mapper = new ObjectMapper();
        List<BloodPressure> list = new ArrayList<>();

        for (HealthData data : healthData) {
            try {
                BloodPressure t = mapper.readValue(data.getData(), BloodPressure.class);
                t.setDate(data.getCreatedAt());
                list.add(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "健康监测", "血压指标");
        model.addAttribute("menuList", menuList);

        model.addAttribute("data", list);

        return "elder/health_blood_pressure";
    }

    @RequestMapping("/blood_sugar")
    private String bloodSugar(@RequestParam Map<String, Object> param, Model model) {
        List<HealthData> healthData;
        List<String> date = handleDefaultDate(param);
        String lDate = date.get(0);
        String rDate = date.get(1);
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        healthData = healthDataService.getHealthDataByDate(HealthData.HTYPE_BLOOD_SUGAR, accountId, lDate, rDate);

        ObjectMapper mapper = new ObjectMapper();
        List<BloodSugar> list = new ArrayList<>();

        for (HealthData data : healthData) {
            try {
                BloodSugar t = mapper.readValue(data.getData(), BloodSugar.class);
                t.setDate(data.getCreatedAt());
                list.add(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "健康监测", "血糖指标");
        model.addAttribute("menuList", menuList);
        model.addAttribute("data", list);
        model.addAttribute("l", lDate);
        model.addAttribute("r", rDate);

        return "elder/health_blood_sugar";
    }

    @RequestMapping("height_weight")
    private String heightWeight(@RequestParam Map<String, Object> param, Model model) {
        List<HealthData> healthData;
        List<String> date = handleDefaultDate(param);
        String lDate = date.get(0);
        String rDate = date.get(1);
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());

        healthData = healthDataService.getHealthDataByDate(HealthData.HTYPE_HEIGHT_WEIGHT, accountId, lDate, rDate);

        ObjectMapper mapper = new ObjectMapper();
        List<HeightWeight> list = new ArrayList<>();

        for (HealthData data : healthData) {
            try {
                HeightWeight t = mapper.readValue(data.getData(), HeightWeight.class);
                t.setDate(data.getCreatedAt());
                list.add(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "健康监测", "身高体重指标");
        model.addAttribute("menuList", menuList);
        model.addAttribute("data", list);
        model.addAttribute("l", lDate);
        model.addAttribute("r", rDate);

        return "elder/health_height_weight";
    }

    private List<String> handleDefaultDate(Map<String, Object> param) {
        String lDate;
        String rDate;
        try {
            lDate = param.get("l").toString();
            rDate = param.get("r").toString();
        } catch (Exception e) {
            Calendar now = Calendar.getInstance();
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

            rDate = ft.format(now.getTime());
            now.add(Calendar.DATE, -7);
            lDate = ft.format(now.getTime());
        }
        List<String> res = new ArrayList<>();
        res.add(lDate);
        res.add(rDate);
        return res;
    }
}
