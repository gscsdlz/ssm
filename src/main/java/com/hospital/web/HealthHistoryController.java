package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.dto.DynamicTableViewResponse;
import com.hospital.entity.*;
import com.hospital.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("health_history")
public class HealthHistoryController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private SickHistoryService sickHistoryService;

    @Autowired
    private CheckHistoryService checkHistoryService;

    @Autowired
    private DrugHistoryService drugHistoryService;

    @Autowired
    private HealthDataService healthDataService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/sick_history")
    private String sickHistoryShow(Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "健康档案", "门诊病历");
        model.addAttribute("menuList", menuList);
        return "/elder/sick_history_show";
    }

    @ResponseBody
    @RequestMapping(value = "/get_sick_history", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    private String getSickHistory() {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        List<SickHistory> data = sickHistoryService.getAllSH(accountId);
        DynamicTableViewResponse<List<SickHistory>> response = new DynamicTableViewResponse<>();
        response.setStatus(true);
        response.setTotalPage(1);
        response.setData(data);
        return response.toString();
    }

    @RequestMapping("/check_history")
    private String checkHistoryShow(Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "健康档案", "检验项目");
        model.addAttribute("menuList", menuList);
        return "/elder/check_history_show";
    }

    @ResponseBody
    @RequestMapping(value = "/get_check_history", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    private String getCheckHistory() {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        List<CheckHistory> data = checkHistoryService.getAllCH(accountId);
        DynamicTableViewResponse<List<CheckHistory>> response = new DynamicTableViewResponse<>();
        response.setStatus(true);
        response.setTotalPage(1);
        response.setData(data);
        return response.toString();
    }

    @RequestMapping("/drug_history")
    private String drugHistoryShow(Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "健康档案", "用药记录");
        model.addAttribute("menuList", menuList);
        return "/elder/drug_history_show";
    }

    @ResponseBody
    @RequestMapping(value = "/get_drug_history", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    private String getDrugHistory() {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        List<DrugHistory> data = drugHistoryService.getAllDH(accountId);
        DynamicTableViewResponse<List<DrugHistory>> response = new DynamicTableViewResponse<>();
        response.setStatus(true);
        response.setTotalPage(1);
        response.setData(data);
        return response.toString();
    }

    @RequestMapping("/me")
    private String myHistoryShow(Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "健康档案", "个人档案");

        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        ObjectMapper mapper = new ObjectMapper();
        try {
            HealthData data = healthDataService.getLastHealthData(HealthData.HTYPE_BLOOD_PRESSURE, accountId);
            BloodPressure bp = mapper.readValue(data.getData(), BloodPressure.class);
            bp.setDate(data.getCreatedAt());
            model.addAttribute("bpData", bp);

            data = healthDataService.getLastHealthData(HealthData.HTYPE_BLOOD_SUGAR, accountId);
            BloodSugar bs = mapper.readValue(data.getData(), BloodSugar.class);
            bs.setDate(data.getCreatedAt());
            model.addAttribute("bsData", bs);

            data = healthDataService.getLastHealthData(HealthData.HTYPE_HEIGHT_WEIGHT, accountId);
            HeightWeight hw = mapper.readValue(data.getData(), HeightWeight.class);
            hw.setDate(data.getCreatedAt());
            model.addAttribute("hwData", hw);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("menuList", menuList);
        return "/elder/my_history_show";
    }
}
