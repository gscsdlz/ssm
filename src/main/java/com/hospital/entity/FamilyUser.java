package com.hospital.entity;

public class FamilyUser {
    private String username;
    private String realname;
    private String phone;
    private String address;
    private String createdAt;
    private String updatedAt;
    private int accountId;

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountId() {
        return accountId;
    }




    public void setUsername(String username) {
        this.username = username;
    }


    public String getUsername() {
        return username;
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

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "FamilyUser{" +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
