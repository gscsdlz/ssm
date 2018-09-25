package com.hospital.web;

import com.hospital.entity.MainMenu;
import com.hospital.service.MenuService;
import com.hospital.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/health_monitor")
public class NoticeController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("notice_show")
    private String noticeShow(@RequestParam Map<String, Object> param, Model model) {

        int type = -1;
        int status = -1;
        try {
            type = Integer.parseInt(param.get("type").toString());
            status = Integer.parseInt(param.get("status").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //TODO 测试Session
        noticeService.getNotice(1, type, status);
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU);
        model.addAttribute("menuList", menuList);
        return "/elder/notice_show";
    }
}
