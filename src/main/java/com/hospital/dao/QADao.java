package com.hospital.dao;

import com.hospital.entity.Answer;
import com.hospital.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface QADao {
    int addQuestion(@Param("account_id") int accountId, @Param("doctor_id") int doctorId, @Param("question") String content);

    int addAnswer(@Param("question_id") int questionId, @Param("answer_content") String answerContent, @Param("user_typr") int userType);

    Question getQuestion(@Param("question_id") int questionId);

    List<Question> getQuestionsByElderId(@Param("account_id") int accountId);

    List<Question> getQuestionsByDoctorId(@Param("doctor_id") int doctorId);

    List<Answer> getAnswers(@Param("question_id") int questionId);

    int removeQA(@Param("question_id") int questionId);

    int removeAnswer(@Param("answer_id") int answerId);

    int removeAnswers(@Param("question_id") int questionId);
}
