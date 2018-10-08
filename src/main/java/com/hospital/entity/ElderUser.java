package com.hospital.entity;

import java.util.Date;

public class ElderUser {
    private int accountId;
    private String username;
    private String realname;
    private int gender;
    private String birth;
    private String address;
    private String phone;
    private String idCard;
    private String ssId; //social security
    private boolean hasAllergy;
    private boolean hasTrauma;
    private boolean hasOperation;
    private boolean hasInheritance;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setSsId(String ssId) {
        this.ssId = ssId;
    }

    public void setHasAllergy(boolean hasAllergy) {
        this.hasAllergy = hasAllergy;
    }

    public void setHasTrauma(boolean hasTrauma) {
        this.hasTrauma = hasTrauma;
    }

    public void setHasOperation(boolean hasOperation) {
        this.hasOperation = hasOperation;
    }

    public void setHasInheritance(boolean hasInheritance) {
        this.hasInheritance = hasInheritance;
    }

    public String getUsername() {
        return username;
    }

    public String getRealname() {
        return realname;
    }

    public int getGender() {
        return gender;
    }

    public String getBirth() {
        return birth;
    }

    public int getAge() {
        return 1;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getSsId() {
        return ssId;
    }

    public String getHasAllergy() {
        return hasAllergy ? "有" : "无";
    }

    public String getHasTrauma() {
        return hasTrauma ? "有" : "无";
    }

    public String getHasOperation() {
        return hasOperation ? "有" : "无";
    }

    public String getHasInheritance() {
        return hasInheritance ? "有" : "无";
    }



}
