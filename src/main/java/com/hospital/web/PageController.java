package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.*;
import com.hospital.service.HealthDataService;
import com.hospital.service.MenuService;
import com.hospital.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private HealthDataService healthDataService;

    @RequestMapping("/home")
    private String index(Model model) {
        List<MainMenu> menuList = menuService.getMenu(1, "", "");
        List<HealthData> bpList = healthDataService.getHealthData(HealthData.HTYPE_BLOOD_PRESSURE, 1);
        List<HealthData> bsList = healthDataService.getHealthData(HealthData.HTYPE_BLOOD_SUGAR, 1);

        List<BloodPressure> bpData = new ArrayList<>();
        List<BloodSugar> bsData = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        for (HealthData data : bpList) {
            try {
                BloodPressure t = mapper.readValue(data.getData(), BloodPressure.class);
                t.setDate(data.getCreatedAt());
                bpData.add(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (HealthData data : bsList) {
            try {
                BloodSugar t = mapper.readValue(data.getData(), BloodSugar.class);
                t.setDate(data.getCreatedAt());
                bsData.add(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("menuList", menuList);
        model.addAttribute("bpData", bpData);
        model.addAttribute("bsData", bsData);
        return "elder/index";
    }
}
