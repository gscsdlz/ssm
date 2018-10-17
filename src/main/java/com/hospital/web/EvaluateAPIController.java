package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.dto.AddResponse;
import com.hospital.dto.DelResponse;
import com.hospital.dto.DynamicTableViewResponse;
import com.hospital.dto.NormalResponse;
import com.hospital.entity.Evaluate;
import com.hospital.service.EvaluateService;
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
@ResponseBody
@RequestMapping(value = "evaluate_api", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8;")
public class EvaluateAPIController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private EvaluateService evaluateService;

    @RequestMapping("get_all")
    private String getAll(@RequestParam Map<String, String> param) {
        int elder_id = Integer.parseInt(param.get("elder_id"));
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());

        request.getSession().setAttribute("tmp_id", elder_id);  //@add function() use
        List<Evaluate> res = evaluateService.getEvaluates(elder_id, accountId);
        DynamicTableViewResponse<List<Evaluate>> response = new DynamicTableViewResponse<>();
        response.setData(res);
        response.setStatus(true);
        return response.toString();
    }

    @RequestMapping("get_my")
    private String getMy() {
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        List<Evaluate> res = evaluateService.getMyEvaluate(accountId);
        DynamicTableViewResponse<List<Evaluate>> response = new DynamicTableViewResponse<>();
        response.setStatus(true);
        response.setData(res);
        return response.toString();
    }

    @ResponseBody
    @RequestMapping("/update")
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
        evaluateService.updateEvaluates(updateStringList);
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }

    @ResponseBody
    @RequestMapping(value = "del", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String del(HttpServletRequest request) {
        String[] delList = request.getParameterValues("ids[]");

        List<Integer> ids = evaluateService.delRows(delList);

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
        int tmpId = Integer.parseInt(request.getSession().getAttribute("tmp_id").toString());
        Map<Integer, String> errors = evaluateService.addEvaluate(accountId, tmpId, Integer.parseInt(info[0]), info[1]);

        AddResponse response = new AddResponse();
        if (errors.size() == 0) {
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
