package com.hospital.entity;

public class Evaluate {
    private int evaluateId;
    private int accountId;
    private String elderName;
    private int doctorId;
    private String doctorName;
    private int evaluate;
    private String suggest;
    private String createdAt;

    public static int EVALUATE_A = 1;
    public static int EVALUATE_B = 2;
    public static int EVALUATE_C = 3;
    public static int EVALUATE_D = 4;

    public void setEvaluateId(int evaluateId) {
        this.evaluateId = evaluateId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setElderName(String elderName) {
        this.elderName = elderName;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setEvaluate(int evaluate) {
        this.evaluate = evaluate;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getEvaluateId() {
        return evaluateId;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getElderName() {
        return elderName;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public int getEvaluate() {
        return evaluate;
    }

    public String getSuggest() {
        return suggest;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
