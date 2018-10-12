package com.hospital.entity;

public class Account {
    private String username;
    private String password;
    private int accountId;
    private int act;
    private String updatedAt;
    private String createdAt;

    public static final int ELDER_USER = 1;
    public static final int DOCTOR_USER = 2;
    public static final int FAMILY_USER = 3;
    public static final int GROUP_USER = 4;
    public static final int SYSTEM_USER = 5;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAct(int act) {
        this.act = act;
    }

    public int getAct() {
        return act;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
