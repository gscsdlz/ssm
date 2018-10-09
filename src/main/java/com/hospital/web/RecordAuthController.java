package com.hospital.web;

import com.hospital.dto.NormalResponse;
import com.hospital.entity.ElderUser;
import com.hospital.entity.MainMenu;
import com.hospital.entity.RecordAuth;
import com.hospital.service.ElderUserService;
import com.hospital.service.MenuService;
import com.hospital.service.RecordAuthService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/apply")
    private String apply(@RequestParam Map<String, Object> param, Model model) {

        String realname = param.get("realname") == null ? "" : param.get("realname").toString();
        String phone = param.get("phone") == null ? "" : param.get("phone").toString();

        List<ElderUser> res = elderUserService.getElderUserByRealnameOrPhone(realname, phone);
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "", "");

        model.addAttribute("data", res);
        model.addAttribute("realname", realname);
        model.addAttribute("phone", phone);
        model.addAttribute("menuList", menuList);
        return "/elder_user/record_apply";
    }

    @ResponseBody
    @RequestMapping(value = "/do_apply", method = RequestMethod.POST, produces = "application/json;charset=utf-8;")
    private String doApply(@RequestParam Map<String, Object> param) {
        int fromId = Integer.parseInt(param.get("from").toString());
        //TODO
        int toId = 1;
        recordAuthService.addRecordAuth(fromId, toId);
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }

    @RequestMapping("/invoke")
    private String invoke(Model model) {
        //TODO
        List<RecordAuth> data = recordAuthService.getRecords(1);
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "", "");

        model.addAttribute("data", data);
        model.addAttribute("menuList", menuList);
        return "/elder_user/record_invoke";
    }
}
