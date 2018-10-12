package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.dto.NormalResponse;
import com.hospital.dto.UserRecordResponse;
import com.hospital.entity.*;
import com.hospital.service.ElderUserService;
import com.hospital.service.HealthDataService;
import com.hospital.service.MenuService;
import com.hospital.service.RecordAuthService;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/record_auth")
public class RecordAuthController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private ElderUserService elderUserService;

    @Autowired
    private RecordAuthService recordAuthService;

    @Autowired
    private HealthDataService healthDataService;

    @RequestMapping("/apply")
    private String apply(@RequestParam Map<String, Object> param, Model model) {

        String realname = param.get("realname") == null ? "" : param.get("realname").toString();
        String phone = param.get("phone") == null ? "" : param.get("phone").toString();

        List<ElderUser> res = elderUserService.getElderUserByRealnameOrPhone(realname, phone);
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "亲人关怀", "健康档案调阅申请");

        model.addAttribute("data", res);
        model.addAttribute("realname", realname);
        model.addAttribute("phone", phone);
        model.addAttribute("menuList", menuList);
        return "/elder/record_apply";
    }

    @ResponseBody
    @RequestMapping(value = "/do_apply", method = RequestMethod.POST, produces = "application/json;charset=utf-8;")
    private String doApply(@RequestParam Map<String, Object> param) {
        int fromId = Integer.parseInt(param.get("id").toString());
        //TODO
        int toId = 1;
        NormalResponse response = new NormalResponse();
        response.setStatus(false);
        if (fromId == toId) {
            response.setInfo("不能申请查看自己！");
            return response.toString();
        }
        try {
            recordAuthService.addRecordAuth(fromId, toId);
            response.setStatus(true);
        } catch (DuplicateKeyException e) {
            response.setInfo("已经申请过了");
        }
        return response.toString();
    }

    @RequestMapping("/invoke")
    private String invoke(Model model) {
        //TODO
        List<RecordAuth> data = recordAuthService.getRecords(1);
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "亲人关怀", "健康档案调阅授权");

        model.addAttribute("data", data);
        model.addAttribute("menuList", menuList);
        return "/elder/record_invoke";
    }

    @ResponseBody
    @RequestMapping(value = "/do_invoke", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String doInvoke(@RequestParam Map<String, String> param) {
        int recordId = Integer.parseInt(param.get("id"));
        int stat = Integer.parseInt(param.get("stat"));
        recordAuthService.recordStatChange(recordId, stat);
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }

    @RequestMapping("/show")
    private String show(Model model) {
        List<RecordAuth> data = recordAuthService.getRecordsTo(1);
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "亲人关怀", "健康档案查询");

        model.addAttribute("data", data);
        model.addAttribute("menuList", menuList);
        return "elder/record_show";
    }

    @ResponseBody
    @RequestMapping(value = "get_record", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    private String getRecord(@RequestParam Map<String, String> param) {
        ObjectMapper mapper = new ObjectMapper();
        UserRecordResponse response = new UserRecordResponse();
        response.setStatus(true);
        try {
            HealthData data = healthDataService.getLastHealthData(HealthData.HTYPE_BLOOD_PRESSURE, 1);
            BloodPressure bp = mapper.readValue(data.getData(), BloodPressure.class);
            bp.setDate(data.getCreatedAt());
            response.setBloodPressure(bp);

            data = healthDataService.getLastHealthData(HealthData.HTYPE_BLOOD_SUGAR, 1);
            BloodSugar bs = mapper.readValue(data.getData(), BloodSugar.class);
            bs.setDate(data.getCreatedAt());
            response.setBloodSugar(bs);

            data = healthDataService.getLastHealthData(HealthData.HTYPE_HEIGHT_WEIGHT, 1);
            HeightWeight hw = mapper.readValue(data.getData(), HeightWeight.class);
            hw.setDate(data.getCreatedAt());
            response.setHeightWeight(hw);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
