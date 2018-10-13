package com.hospital.web;

import com.hospital.dto.NormalResponse;
import com.hospital.entity.MainMenu;
import com.hospital.entity.Notice;
import com.hospital.service.MenuService;
import com.hospital.service.NoticeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.PipedOutputStream;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/health_monitor")
public class NoticeController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("notice_show")
    private String noticeShow(@RequestParam Map<String, Object> param, Model model) {

        int type = -2;
        int status = -2;
        try {
            type = Integer.parseInt(param.get("type").toString());
            status = Integer.parseInt(param.get("status").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());

        List<Notice> list = noticeService.getNotice(accountId, type, status);
        List<MainMenu> menuList = menuService.getMenu(MenuService.ELDER_MENU, "健康监护", "提醒设置");
        model.addAttribute("menuList", menuList);
        model.addAttribute("data", list);
        model.addAttribute("noticeTypes", Notice.noticeTypes);
        return "/elder/notice_show";
    }

    @ResponseBody
    @RequestMapping(value = "add_notice", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String addNotice(@RequestParam Map<String, Object> param) {
        int noticeType = Integer.parseInt(param.get("type").toString());
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        String start = param.get("start").toString();
        String end = param.get("end").toString();
        String frequency = param.get("frequency").toString();

        noticeService.addNotice(noticeType, accountId, start, end, frequency);

        NormalResponse response = new NormalResponse();
        response.setStatus(true);

        return response.toString();
    }

    @ResponseBody
    @RequestMapping(value = "update_notice", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String updateNotice(@RequestParam Map<String, Object> param) {

        int noticeId = Integer.parseInt(param.get("noticeId").toString());
        int noticeType = Integer.parseInt(param.get("type").toString());
        String start = param.get("start").toString();
        String end = param.get("end").toString();
        String frequency = param.get("frequency").toString();

        noticeService.updateNotice(noticeId, noticeType, start, end, frequency);

        NormalResponse response = new NormalResponse();
        response.setStatus(true);

        return response.toString();
    }

    @ResponseBody
    @RequestMapping(value = "del_notice", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private String delNotice(@RequestParam Map<String, Object> param) {

        int noticeId = Integer.parseInt(param.get("noticeId").toString());

        noticeService.delNotice(noticeId);

        NormalResponse response = new NormalResponse();
        response.setStatus(true);

        return response.toString();
    }
}
