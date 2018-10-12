package com.hospital.web;

import com.hospital.dto.ElderUserCountResponse;
import com.hospital.entity.DrugHistory;
import com.hospital.entity.HealthData;
import com.hospital.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "user_count", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=utf-8")
public class UserCountController {

    @Autowired
    private HealthDataService healthDataService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private SickHistoryService sickHistoryService;

    @Autowired
    private CheckHistoryService checkHistoryService;

    @Autowired
    private DrugHistoryService drugHistoryService;

    @ResponseBody
    @RequestMapping("elder")
    private String elder(@RequestParam Map<String, String> param) {
        ElderUserCountResponse count = new ElderUserCountResponse();
        //TODO
        int accountId = 1;
        if (param.get("id") != null) {
            accountId = Integer.parseInt(param.get("id"));
        }

        count.setHealthDataCount(healthDataService.countHealthData(accountId));
        count.setJoin(accountService.countJoin(accountId));
        count.setSicks(sickHistoryService.countSicks(accountId));
        count.setChecks(checkHistoryService.countChecks(accountId));
        count.setDrugs(drugHistoryService.countDrugs(accountId));

        count.setStatus(true);
        return count.toString();
    }
}
