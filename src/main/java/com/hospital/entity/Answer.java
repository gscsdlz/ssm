package com.hospital.entity;

public class Answer {
    private int answerId;
    private String answerContent;
    private int userType;
    private String realname;
    private String createdAt;

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getAnswerId() {
        return answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public int getUserType() {
        return userType;
    }

    public String getRealname() {
        return realname;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
