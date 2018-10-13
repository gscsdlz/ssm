package com.hospital.entity;

import java.util.List;

public class Question {
    private int questionId;
    private String question;
    private int accountId;
    private int doctorId;
    private String elderName;
    private String doctorName;
    private String createdAt;
    private List<Answer> answers;

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setElderName(String elderName) {
        this.elderName = elderName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getElderName() {
        return elderName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
