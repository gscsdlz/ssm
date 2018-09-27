package com.hospital.web;

import com.hospital.entity.MainMenu;
import com.hospital.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/elder_user/")
public class ElderUserController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("me")
    private String me(Model model)
    {
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "", "");
        model.addAttribute("menuList", menuList);
        return "/elder/user";
    }
}
