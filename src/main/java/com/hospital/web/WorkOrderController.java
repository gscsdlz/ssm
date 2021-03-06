package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.dto.AddResponse;
import com.hospital.dto.DelResponse;
import com.hospital.dto.DynamicTableViewResponse;
import com.hospital.dto.NormalResponse;
import com.hospital.entity.ElderUser;
import com.hospital.entity.MainMenu;
import com.hospital.entity.WorkOrder;
import com.hospital.service.ElderUserService;
import com.hospital.service.MenuService;
import com.hospital.service.WorkOrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.applet.Main;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("work_order")
public class WorkOrderController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MenuService menuService;

    @Autowired
    private WorkOrderService workOrderService;

    @Autowired
    private ElderUserService elderUserService;

    @RequestMapping("show")
    private String show(Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.GROUP_MENU, "工单管理", "工单处理");
        model.addAttribute("menuList", menuList);
        return "group/work_order";
    }

    @ResponseBody
    @RequestMapping(value = "get", method = RequestMethod.GET, produces = "application/json;charset=utf-8;")
    private String get() {
        List<WorkOrder> list = workOrderService.getAll();
        DynamicTableViewResponse<List<WorkOrder>> response = new DynamicTableViewResponse<>();
        response.setData(list);
        response.setStatus(true);
        return response.toString();
    }

    @ResponseBody
    @RequestMapping(value = "del", method = RequestMethod.POST, produces = "application/json;charset=utf-8;")
    private String del() {
        String[] delList = request.getParameterValues("ids[]");

        List<Integer> ids = workOrderService.delRows(delList);

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
    @RequestMapping(value = "update", method = RequestMethod.POST, produces = "application/json;charset=utf-8;")
    private String update() {
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

        workOrderService.updateRows(updateStringList);
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }

    @ResponseBody
    @RequestMapping(value = "init", method = RequestMethod.GET, produces = "application/json;charset=utf-8;")
    private String getAllElders() {
        DynamicTableViewResponse<List<ElderUser>> response = new DynamicTableViewResponse<>();
        response.setStatus(true);
        response.setData(elderUserService.getAllElderUser());
        return response.toString();
    }

    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String add(HttpServletRequest request) {
        String[] info = request.getParameterValues("info[]");
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        Map<Integer, String> errors = workOrderService.addWorkOrder(accountId, info);

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
