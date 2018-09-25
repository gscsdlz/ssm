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

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    private String get(@RequestParam Map<String, Object> param) {
        int currPage = 1;
        try {
            currPage = Integer.parseInt(param.get("currentPage").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //TODO 测试Session
        List<Warning> warnings = warningService.getWarning(1, currPage, 10);

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
        //TODO 测试Session
        alarmService.removeAlarm(1);
        alarmService.updateAlarm(1);
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
        //TODO 测试Session
        Map<Integer, String> errors = warningService.addRow(info, 1);


        AddResponse response = new AddResponse();
        if (errors.size() == 0) {
            alarmService.updateAlarm(1);
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
