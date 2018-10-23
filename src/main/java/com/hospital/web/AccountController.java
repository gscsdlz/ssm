package com.hospital.web;

import com.hospital.dto.NormalResponse;
import com.hospital.entity.Account;
import com.hospital.service.*;
import com.hospital.utils.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private DoctorUserService doctorUserService;

    @Autowired
    private FamilyUserService familyUserService;

    @Autowired
    private GroupUserService groupUserService;

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
            session.setAttribute("act", act);
            response.setStatus(true);
        } else {
            response.setStatus(false);
            response.setInfo("用户名或者密码错误");
        }
        return response.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String register(@RequestParam Map<String, String> param) {
        String username = param.get("username");
        String password = param.get("password");
        int act = Integer.parseInt(param.get("act"));
        NormalResponse response = new NormalResponse();

        if (act == Account.SYSTEM_USER) {
            response.setStatus(false);
            response.setInfo("系统用户不能自行注册");
            return response.toString();
        }
        if (accountService.getUserByUsername(username) == null) {
            accountService.addUser(username, password, act);
            Account account = accountService.getUserByUsername(username);
            int accountId = account.getAccountId();
            switch (act) {
                case Account.ELDER_USER:
                    elderUserService.addElderUser(accountId, username);
                    break;
                case Account.DOCTOR_USER:
                    doctorUserService.addDoctorUser(accountId, username);
                    break;
                case Account.FAMILY_USER:
                    familyUserService.addFamilyUser(accountId, username);
                    break;
                case Account.GROUP_USER:
                    groupUserService.addGroupUser(accountId, username);
                    break;
            }
            request.getSession().setAttribute("account_id", accountId);
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("act", act);
            response.setStatus(true);
        } else {
            response.setStatus(false);
            response.setInfo("用户名已经被使用过了");
        }
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
            case Account.DOCTOR_USER:
                mv = new ModelAndView("redirect:/doctor_user/me");
                break;
            case Account.FAMILY_USER:
                mv = new ModelAndView("redirect:/family_user/me");
                break;
            case Account.GROUP_USER:
                mv = new ModelAndView("redirect:/group_user/me");
                break;
            default:
                mv = new ModelAndView();
        }
        return mv;
    }

    @RequestMapping("logout")
    private String logout() {
        request.getSession().removeAttribute("account_id");
        request.getSession().removeAttribute("act");
        request.getSession().removeAttribute("username");
        return "redirect:/login";
    }
}
