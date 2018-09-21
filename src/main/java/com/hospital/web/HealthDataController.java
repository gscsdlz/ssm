package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.BloodPressure;
import com.hospital.entity.HealthData;
import com.hospital.entity.MainMenu;
import com.hospital.service.HealthDataService;
import com.hospital.service.MenuService;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("health_data")
public class HealthDataController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private HealthDataService healthDataService;

    @RequestMapping("/blood_pressure")
    private String bloodPressure(Model model) {
        //TODO 测试Session
        List<HealthData> healthData = healthDataService.getHealthData(HealthData.HTYPE_BLOOD_PRESSURE, 1);
        ObjectMapper mapper = new ObjectMapper();
        List<BloodPressure> list = new ArrayList<>();

        for (HealthData data : healthData) {
            try {
                BloodPressure t = mapper.readValue(data.getData(), BloodPressure.class);
                list.add(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<MainMenu> menuList = menuService.getMenu(1);
        model.addAttribute("menuList", menuList);
        model.addAttribute("data", list);

        return "elder/health_blood_pressure";
    }
}
