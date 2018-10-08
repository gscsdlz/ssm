package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.dto.NormalResponse;
import com.hospital.entity.ElderUser;
import com.hospital.entity.HealthData;
import com.hospital.entity.MainMenu;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/elder_user/")
public class ElderUserController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private ElderUserService elderUserService;

    @RequestMapping("me")
    private String me(Model model)
    {
        //TODO
        ElderUser user = elderUserService.getElderUser(1);
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "", "");
        model.addAttribute("user", user);
        model.addAttribute("menuList", menuList);

        return "/elder/user";
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
            //TODO
            user.setAccountId(1);
            elderUserService.updateUser(user);

        } catch (Exception e) {
            ;
        }
        if (user != null) {
            response.setStatus(true);
        }
        return response.toString();
    }
}
