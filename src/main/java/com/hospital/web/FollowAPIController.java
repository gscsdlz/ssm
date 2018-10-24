package com.hospital.web;

import com.hospital.dto.NormalResponse;
import com.hospital.entity.ElderUser;
import com.hospital.service.ElderUserService;
import com.hospital.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ResponseBody
@RequestMapping(value = "follow_api", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
@Controller
public class FollowAPIController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ElderUserService elderUserService;

    @Autowired
    private FollowService followService;

    @RequestMapping("follow")
    private String follow(@RequestParam Map<String, String> param) {
        String idCard = param.get("id_card");
        ElderUser user = elderUserService.getElderUserByIdCard(idCard);
        NormalResponse response = new NormalResponse();
        if (user == null) {
            response.setStatus(false);
            response.setInfo("找不到这样的用户");
        } else {
            int familyId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
            try {
                followService.addHomeElder(familyId, user.getAccountId());
                response.setStatus(true);
            } catch (DuplicateKeyException e) {
                response.setStatus(false);
                response.setInfo("不能重复关注");
            }

        }
        return response.toString();
    }

    @RequestMapping("unfollow")
    private String unFollow(@RequestParam Map<String, String> param) {
        int familyId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        int accountId = Integer.parseInt(param.get("id"));
        followService.removeHomeElder(familyId, accountId);
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }

}
