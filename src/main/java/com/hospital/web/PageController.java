package com.hospital.web;

import com.hospital.entity.MainMenu;
import com.hospital.entity.Menu;
import com.hospital.service.MenuService;
import com.hospital.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/home")
    private String index(Model model) {
        List<MainMenu> menuList = menuService.getMenu(1);
        model.addAttribute("menuList", menuList);
        return "index";
    }
}
