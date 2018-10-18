package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.dto.DynamicTableViewResponse;
import com.hospital.dto.NormalResponse;
import com.hospital.entity.*;
import com.hospital.service.ElderUserService;
import com.hospital.service.HealthDataService;
import com.hospital.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/elder_user/")
public class ElderUserController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private ElderUserService elderUserService;

    @Autowired
    private HealthDataService healthDataService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("me")
    private String me(Model model)
    {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        ElderUser user = elderUserService.getElderUser(accountId);
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "", "");
        model.addAttribute("user", user);
        model.addAttribute("menuList", menuList);

        return "/elder/user";
    }

    @RequestMapping("/home")
    private String home(Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "", "");
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());

        List<HealthData> bpList = healthDataService.getHealthData(HealthData.HTYPE_BLOOD_PRESSURE, accountId);
        List<HealthData> bsList = healthDataService.getHealthData(HealthData.HTYPE_BLOOD_SUGAR, accountId);

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

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String update(@RequestParam Map<String, Object> param, Model model) {
        String info = param.get("json").toString();
        ObjectMapper mapper = new ObjectMapper();
        ElderUser user = null;
        NormalResponse response = new NormalResponse();
        try {
            user = mapper.readValue(info, ElderUser.class);
            int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
            user.setAccountId(accountId);
            elderUserService.updateUser(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user != null) {
            response.setStatus(true);
        }
        return response.toString();
    }

    @ResponseBody
    @RequestMapping(value = "put_info_to_family", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
    private String getInfoByFamilyUser(@RequestParam Map<String, String> param) {
        int accountId = Integer.parseInt(param.get("id"));
        ElderUser user = elderUserService.getElderUser(accountId);
        DynamicTableViewResponse<ElderUser> response = new DynamicTableViewResponse<>();
        response.setData(user);
        response.setStatus(true);
        return response.toString();
    }
}
