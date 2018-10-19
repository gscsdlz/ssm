package com.hospital.web;

import com.hospital.dto.NormalResponse;
import com.hospital.service.AccountService;
import com.hospital.service.DoctorUserService;
import com.hospital.service.ElderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping(value = "user_manage_api", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
public class UserManageAPIController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AccountService accountService;

    @RequestMapping("disabled")
    private String disabled(@RequestParam Map<String, String> param) {
        int accountId = Integer.parseInt(param.get("account_id"));
        int disable = Integer.parseInt(param.get("disable"));
        accountService.disable(accountId, disable);
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }

    @RequestMapping("reset")
    private String initPassword(@RequestParam Map<String, String> param) {
        int accountId = Integer.parseInt(param.get("account_id"));
        accountService.resetPassword(accountId);
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }

}
