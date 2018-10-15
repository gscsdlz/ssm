package com.hospital.service;

import com.hospital.entity.Answer;
import com.hospital.entity.Question;

import java.util.List;

public interface QAService {
    int addQuestion(int accountId, int doctorId, String content);

    int addAnswer(int questionId, String answerContent, int userType);

    Question getQuestion(int questionId);

    List<Question> getQuestionsByElderId(int accountId);

    List<Question> getQuestionsByDoctorId(int doctorId);

    List<Answer> getAnswers(int questionId);

    int removeQA(int questionId);

    int removeAnswer(int answerId);

    int removeAnswers(int questionId);

    int removeQAByUId(int accountId, int doctorId);
}
