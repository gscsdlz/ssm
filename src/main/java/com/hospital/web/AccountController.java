package com.hospital.web;

import com.hospital.dto.Result;
import com.hospital.entity.Account;
import com.hospital.service.AccountService;
import com.hospital.service.ElderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private ElderUserService elderUserService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private Result<Account> login(@RequestParam Map<String, Object> param) {

        String username = param.get("username").toString();
        String password = param.get("password").toString();
        int act = Integer.parseInt(param.get("act").toString());

        Account user = accountService.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password) && act == user.getAct()) {
            ModelAndView mav = new ModelAndView("session");
            mav.addObject("user", user);
            return new Result<>(true, "");
        } else {
            return new Result<>(false, "用户名或者密码错误");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private Result<Account> register(@RequestParam Map<String, Object> param) {

        try {
            String username = param.get("username").toString();
            String password = param.get("password").toString();
            int act = Integer.parseInt(param.get("act").toString());

            Account account = accountService.getUserByUsername(username);
            if (account != null) {
                return new Result<>(false, "用户名重复");
            } else {
                int accountId = accountService.addUser(username, password, act);
                switch (act) {
                    case Account.ELDER_USER: {
                        elderUserService.addUser(accountId);
                        break;
                    }
                    default: {

                    }

                }
            }
            return new Result<>(true, "");

        } catch (Exception e) {
            System.out.println(e);
        }
        return new Result<>(false, "注册失败");
    }
}
