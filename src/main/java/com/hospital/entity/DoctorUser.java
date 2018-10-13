package com.hospital.entity;

public class DoctorUser {
    private int accountId;
    private String realname;
    private String username;
    private String phone;
    private String address;
    private String hospitalName;
    private String section;
    private String icon;
    private int gender;
    private int age;
    private String createdAt;

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getRealname() {
        return realname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getSection() {
        return section;
    }

    public String getIcon() {
        return icon;
    }

    public String getGender() {
        return gender == 1 ? "男" : "女";
    }

    public int getAge() {
        return age;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUsername() {
        return username;
    }
}
