package com.hospital.web;

import com.hospital.entity.ElderUser;
import com.hospital.entity.MainMenu;
import com.hospital.service.FollowService;
import com.hospital.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("family_user")
public class FamilyUserController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FollowService followService;

    private String me() {
        return "";
    }

    private String home() {
        return "";
    }

    @RequestMapping("record")
    private String elderRecord(Model model) {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        List<ElderUser> list = followService.getHomeElders(accountId);
        List<MainMenu> menuList = menuService.getMenu(MenuService.FAMILY_MENU, "", "");

        model.addAttribute("elders", list);
        model.addAttribute("menuList", menuList);
        return "family/record";
    }
}
