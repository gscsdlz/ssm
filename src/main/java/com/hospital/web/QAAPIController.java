package com.hospital.web;

import com.hospital.dto.NormalResponse;
import com.hospital.service.QAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping(value = "qa_api", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
public class QAAPIController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private QAService qaService;

    @RequestMapping("add_question")
    private String addQuestion(@RequestParam Map<String, String> param) {
        String content = param.get("question");
        int doctorId = Integer.parseInt(param.get("doctor_id"));
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        qaService.addQuestion(accountId, doctorId, content);
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }

    @RequestMapping("add_answer")
    private String addAnswer(@RequestParam Map<String, String> param) {
        String answerContent = param.get("answer_content");
        int questionId = Integer.parseInt(param.get("question_id"));
        int act = Integer.parseInt(request.getSession().getAttribute("act").toString());
        qaService.addAnswer(questionId, answerContent, act);
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }

    @RequestMapping("del_question")
    private String removeQuestion(@RequestParam Map<String, String> param) {
        int questionId = Integer.parseInt(param.get("question_id"));
        int accountId = Integer.parseInt(request.getSession().getAttribute("account_id").toString());
        qaService.removeQA(questionId);
        NormalResponse response = new NormalResponse();
        response.setStatus(true);
        return response.toString();
    }
}
