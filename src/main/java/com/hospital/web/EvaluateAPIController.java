package com.hospital.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "evaluate_api", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8;")
public class EvaluateAPIController {
    @Autowired
    private HttpServletRequest request;

    private String getAll() {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        return "";
    }
}
