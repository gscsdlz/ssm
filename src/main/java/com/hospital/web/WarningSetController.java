package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.hospital.dto.*;
import com.hospital.entity.Warning;
import com.hospital.service.AlarmService;
import com.hospital.service.WarningService;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/warning_set_api")
public class WarningSetController {

    @Autowired
    private WarningService warningService;

    @Autowired
    private AlarmService alarmService;

    @Autowired
    private HttpServletRequest request;

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    private String get(@RequestParam Map<String, Object> param) {
        int currPage = 1;
        try {
            currPage = Integer.parseInt(param.get("currentPage").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        List<Warning> warnings = warningService.getWarning(accountId, currPage, 10);
        WarningSetResponse response = new WarningSetResponse();
        response.setCurrentPage(currPage);
        //TODO 分页还没有写好
        response.setTotalPage(1);
        response.setStatus(true);
        response.setData(warnings);
        response.setSelectMap(Warning.keyNames);

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(response);
        } catch (Exception e) {
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String update(HttpServletRequest request) {

        List<String[]> updateStringList = new ArrayList<>();
        int num = 0;
        while (true) {
            String infos = "infos[" + (num++) + "][]";
            String[] updateList = request.getParameterValues(infos);
            if (updateList != null) {
                updateStringList.add(updateList);
            } else {
                break;
            }
        }

        warningService.updateRows(updateStringList);
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        alarmService.removeAlarm(accountId);
        alarmService.updateAlarm(accountId);
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(response);
        } catch (Exception e) {
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = "del", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String del(HttpServletRequest request) {
        String[] delList = request.getParameterValues("ids[]");

        List<Integer> ids = warningService.delRows(delList);

        DelResponse response = new DelResponse();
        response.setStatus(true);
        response.setIds(ids);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(response);
        } catch (Exception e) {
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String add(HttpServletRequest request) {
        String[] info = request.getParameterValues("info[]");
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        Map<Integer, String> errors = warningService.addRow(info, accountId);


        AddResponse response = new AddResponse();
        if (errors.size() == 0) {
            alarmService.updateAlarm(accountId);
            response.setStatus(true);
        } else
            response.setStatus(false);
        response.setErrors(errors);
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(response);
        } catch (Exception e) {
            return "";
        }
    }
}
