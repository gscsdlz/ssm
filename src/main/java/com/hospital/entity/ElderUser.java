package com.hospital.entity;

import java.util.Date;

public class ElderUser {
    private int accountId;
    private String username;
    private String realname;
    private int gender;
    private int age;
    private String address;
    private String phone;
    private String idCard;
    private String ssId; //social security
    private int hasAllergy;
    private int hasTrauma;
    private int hasOperation;
    private int hasInheritance;

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

    public void setHasAllergy(int hasAllergy) {
        this.hasAllergy = hasAllergy;
    }

    public void setHasTrauma(int hasTrauma) {
        this.hasTrauma = hasTrauma;
    }

    public void setHasOperation(int hasOperation) {
        this.hasOperation = hasOperation;
    }

    public void setHasInheritance(int hasInheritance) {
        this.hasInheritance = hasInheritance;
    }

    public String getUsername() {
        return username;
    }

    public String getRealname() {
        return realname;
    }

    public String getGender() {
        return gender == 0 ? "男" : "女";
    }

    public int getGenderInt() {
        return gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
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
        return hasAllergy == 1 ? "有" : "无";
    }

    public String getHasTrauma() {
        return hasTrauma == 1 ? "有" : "无";
    }

    public String getHasOperation() {
        return hasOperation == 1 ? "有" : "无";
    }

    public String getHasInheritance() {
        return hasInheritance == 1 ? "有" : "无";
    }

}
