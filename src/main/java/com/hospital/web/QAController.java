package com.hospital.web;

import com.hospital.entity.MainMenu;
import com.hospital.entity.Question;
import com.hospital.service.MenuService;
import com.hospital.service.QAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/qa")
public class QAController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private QAService qaService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("get_elder_question")
    private String showQuestion(@RequestParam Map<String, String> param, Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "", "");
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        List<Question> list = qaService.getQuestionsByElderId(accountId);

        model.addAttribute("menuList", menuList);
        model.addAttribute("data", list);
        return "elder/question";
    }

}
