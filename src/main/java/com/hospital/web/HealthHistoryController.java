package com.hospital.web;

import com.hospital.dto.DynamicTableViewResponse;
import com.hospital.entity.*;
import com.hospital.service.CheckHistoryService;
import com.hospital.service.DrugHistoryService;
import com.hospital.service.MenuService;
import com.hospital.service.SickHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/sick_history")
    private String sickHistoryShow(Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "健康档案", "门诊病历");
        model.addAttribute("menuList", menuList);
        return "/elder/sick_history_show";
    }

    @ResponseBody
    @RequestMapping(value = "/get_sick_history", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    private String getSickHistory() {
        //TODO 测试Session
        List<SickHistory> data = sickHistoryService.getAllSH(1);
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
        //TODO 测试Session
        List<CheckHistory> data = checkHistoryService.getAllCH(1);
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
        //TODO 测试Session
        List<DrugHistory> data = drugHistoryService.getAllDH(1);
        DynamicTableViewResponse<List<DrugHistory>> response = new DynamicTableViewResponse<>();
        response.setStatus(true);
        response.setTotalPage(1);
        response.setData(data);
        return response.toString();
    }
}
