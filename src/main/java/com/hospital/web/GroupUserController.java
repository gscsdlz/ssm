package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.dto.NormalResponse;
import com.hospital.entity.GroupUser;
import com.hospital.entity.MainMenu;
import com.hospital.service.GroupUserService;
import com.hospital.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("group_user")
public class GroupUserController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private GroupUserService groupUserService;

    @RequestMapping("home")
    private String home(Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.GROUP_MENU, "", "");
        model.addAttribute("menuList", menuList);
        return "group/index";
    }

    @RequestMapping("me")
    private String me(Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.GROUP_MENU, "", "");
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        GroupUser user = groupUserService.getUserById(accountId);
        model.addAttribute("user", user);
        model.addAttribute("menuList", menuList);
        return "group/user";
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String update(@RequestParam Map<String, String> param) {
        String info = param.get("json");
        ObjectMapper mapper = new ObjectMapper();
        GroupUser user = null;
        try {
            user = mapper.readValue(info, GroupUser.class);
            int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
            user.setAccountId(accountId);
            groupUserService.updateGroupUser(accountId, user.getRealname(), user.getPhone(), user.getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }
}
