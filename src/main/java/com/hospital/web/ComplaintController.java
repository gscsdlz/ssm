package com.hospital.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.dto.DelResponse;
import com.hospital.dto.DynamicTableViewResponse;
import com.hospital.dto.NormalResponse;
import com.hospital.entity.Complaint;
import com.hospital.entity.MainMenu;
import com.hospital.service.ComplaintService;
import com.hospital.service.MenuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.applet.Main;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("complaint")
public class ComplaintController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping("/un_handle")
    private String unHandle(Model model) {

        List<MainMenu> menuList = menuService.getMenu(MenuService.GROUP_MENU, "投诉管理", "待处投诉");
        model.addAttribute("menuList", menuList);
        model.addAttribute("handle", 0);
        return "group/complaint";
    }

    @RequestMapping("/handle")
    private String handle(Model model) {
        List<MainMenu> menuList = menuService.getMenu(MenuService.GROUP_MENU, "投诉管理", "已处理投诉");
        model.addAttribute("menuList", menuList);
        model.addAttribute("handle", 1);
        return "group/complaint";
    }

    @ResponseBody
    @RequestMapping(value = "get", method = RequestMethod.GET, produces = "application/json;charset=utf-8;")
    private String getComplaint(@RequestParam Map<String, String> param) {
        int handle = 0;
        try {
            handle = Integer.parseInt(param.get("handle"));
        } catch (Exception e) {
            ;
        }
        List<Complaint> complaintList = complaintService.getComplaint(handle);
        for (Complaint complaint : complaintList) {
            //TODO handle为0 原因未知
            complaint.setHandle(handle);
        }
        DynamicTableViewResponse<List<Complaint>> response = new DynamicTableViewResponse<>();
        response.setData(complaintList);
        response.setStatus(true);
        return response.toString();
    }

    @ResponseBody
    @RequestMapping(value = "del", method = RequestMethod.POST, produces = "application/json;charset=utf-8;")
    private String delComplaint() {
        String[] delList = request.getParameterValues("ids[]");

        List<Integer> ids = complaintService.delRows(delList);

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
    private String updateComplaint() {
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

        complaintService.updateRows(updateStringList);
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }

    @RequestMapping("stat")
    private String stat(Model model) {
        List<Complaint> complaintList = complaintService.getAllComplaint();
        List<MainMenu> menuList = menuService.getMenu(MenuService.GROUP_MENU, "投诉管理", "总投诉量");
        Map<String, Integer> data = new TreeMap<>();

        for(Complaint complaint : complaintList) {
            String key = complaint.getCreatedAt().substring(0, 7);
            if (data.get(key) == null) {
                data.put(key, 0);
            }
            int num = data.get(key);
            num++;
            data.put(key, num);
        }

        model.addAttribute("data", data);
        model.addAttribute("menuList", menuList);
        return "group/stat";
    }
}
