package com.hospital.web;

import com.hospital.dto.NormalResponse;
import com.hospital.dto.Result;
import com.hospital.entity.Account;
import com.hospital.service.AccountService;
import com.hospital.service.ElderUserService;
import com.hospital.utils.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ElderUserService elderUserService;

    @Autowired
    private HttpServletRequest request;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String login(@RequestParam Map<String, Object> param) {
        String username = param.get("username").toString();
        String password = Encrypt.sha1Encode(param.get("password").toString());
        int act = Integer.parseInt(param.get("act").toString());

        Account user = accountService.getUserByUsername(username);
        NormalResponse response = new NormalResponse();
        if (user != null && user.getPassword().equals(password) && act == user.getAct()) {
            HttpSession session = request.getSession();
            session.setAttribute("account_id", user.getAccountId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("type", act);
            response.setStatus(true);
        } else {
            response.setStatus(false);
            response.setInfo("用户名或者密码错误");
        }
        return response.toString();
    }

    private String register(@RequestParam Map<String, String> param) {
        NormalResponse response = new NormalResponse();
        return response.toString();
    }

    @RequestMapping("me")
    private ModelAndView userCenter() {
        HttpSession session = request.getSession();
        ModelAndView mv;
        switch (Integer.parseInt(session.getAttribute("act").toString())) {
            case Account.ELDER_USER:
                mv = new ModelAndView("redirect:/elder_user/me");
            break;
            default:
                mv = new ModelAndView();
        }
        return mv;
    }
}
