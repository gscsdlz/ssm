package com.hospital.entity;

import java.util.Date;

public class ElderUser {
    private int accountId;
    private String realName;
    private Date birth;
    private int gender;
    private String phone;
    private String idCard;
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getRealName() {
        return realName;
    }

    public Date getBirth() {
        return birth;
    }

    public int getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getIdCard() {
        return idCard;
    }
}
