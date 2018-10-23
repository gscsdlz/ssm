package com.hospital.web;

import com.hospital.entity.DoctorUser;
import com.hospital.entity.ElderUser;
import com.hospital.entity.MainMenu;
import com.hospital.entity.Position;
import com.hospital.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user_manage")
public class UserManageController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MenuService menuService;

    @Autowired
    private ElderUserService elderUserService;

    @Autowired
    private DoctorUserService doctorUserService;

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private PositionService positionService;

    @RequestMapping("elder")
    private String elderShow(@RequestParam Map<String, String> param, Model model) {
        int elderId = 0;
        try {
            elderId = Integer.parseInt(param.get("id"));
        } catch (Exception e) {
            ;
        }
        ElderUser user = elderUserService.getElderUser(elderId);
        List<DoctorUser> doctors = connectionService.getMyDoctors(elderId);
        int act = Integer.parseInt(request.getSession().getAttribute("act").toString());
        List<MainMenu> menuList = menuService.getMenu(act, "档案管理" ,"老人档案");
        List<ElderUser> elderUsers = elderUserService.getAllElderUser();
        model.addAttribute("elders", elderUsers);
        model.addAttribute("user", user);
        model.addAttribute("doctors", doctors);
        model.addAttribute("menuList", menuList);
        return "group/elder";
    }

    @RequestMapping("doctor")
    private String doctorShow(@RequestParam Map<String, String> param, Model model) {
        int doctorId = 0;
        try {
            doctorId = Integer.parseInt(param.get("id"));
        } catch (Exception e) {
            ;
        }
        DoctorUser user = doctorUserService.getDoctorUser(doctorId);
        List<ElderUser> elders = connectionService.getMyElders(doctorId);
        int act = Integer.parseInt(request.getSession().getAttribute("act").toString());
        List<MainMenu> menuList = menuService.getMenu(act, "档案管理" ,"家庭医生");
        List<DoctorUser> doctorUserList = doctorUserService.getAllDoctors();
        model.addAttribute("user", user);
        model.addAttribute("elders", elders);
        model.addAttribute("doctors", doctorUserList);
        model.addAttribute("menuList", menuList);
        return "group/doctor";
    }

    @RequestMapping("position")
    private String position(@RequestParam Map<String, String> param, Model model) {
        int elderId = 0;
        try {
            elderId = Integer.parseInt(param.get("id"));
        } catch (Exception e) {
            ;
        }
        Position pos = positionService.queryLastPosition(elderId);
        ElderUser user = elderUserService.getElderUser(elderId);
        int act = Integer.parseInt(request.getSession().getAttribute("act").toString());
        List<MainMenu> menuList = menuService.getMenu(act, "档案管理" ,"老人定位");
        List<ElderUser> elderUsers = elderUserService.getAllElderUser();

        model.addAttribute("position", pos);
        model.addAttribute("elders", elderUsers);
        model.addAttribute("user", user);
        model.addAttribute("menuList", menuList);
        return "group/position";
    }
}
