package com.hospital.web;

import com.hospital.entity.MainMenu;
import com.hospital.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("group_user")
public class GroupUserController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("home")
    private String home(Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.GROUP_MENU, "", "");
        model.addAttribute("menuList", menuList);
        return "group/index";
    }

    @RequestMapping("me")
    private String me(Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.GROUP_MENU, "", "");
        model.addAttribute("menuList", menuList);
        return "group/user";
    }
}
