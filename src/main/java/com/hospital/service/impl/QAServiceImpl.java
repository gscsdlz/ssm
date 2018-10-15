package com.hospital.service.impl;

import com.hospital.dao.QADao;
import com.hospital.entity.Answer;
import com.hospital.entity.Question;
import com.hospital.service.QAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QAServiceImpl implements QAService {

    @Autowired
    private QADao qaDao;

    @Override
    public int addQuestion(int accountId, int doctorId, String content) {
        return qaDao.addQuestion(accountId, doctorId, content);
    }

    @Override
    public int addAnswer(int questionId, String answerContent, int userType) {
        return qaDao.addAnswer(questionId, answerContent, userType);
    }

    @Override
    public Question getQuestion(int questionId) {
        return qaDao.getQuestion(questionId);
    }

    @Override
    public List<Question> getQuestionsByElderId(int accountId) {
        return qaDao.getQuestionsByElderId(accountId);
    }

    @Override
    public List<Question> getQuestionsByDoctorId(int doctorId) {
        return qaDao.getQuestionsByDoctorId(doctorId);
    }

    @Override
    public List<Answer> getAnswers(int questionId) {
        return qaDao.getAnswers(questionId);
    }

    @Override
    public int removeQA(int questionId) {
        return qaDao.removeQA(questionId);
    }

    @Override
    public int removeAnswer(int answerId) {
        return qaDao.removeAnswer(answerId);
    }

    @Override
    public int removeAnswers(int questionId) {
        return qaDao.removeAnswers(questionId);
    }
}
