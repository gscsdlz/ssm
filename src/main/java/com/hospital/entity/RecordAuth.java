package com.hospital.entity;

public class RecordAuth {
    private int recordId;
    private int fromId; //被查看者ID
    private int toId;  //发起查看者ID
    private int stat;
    private String realname;
    private String address;
    private String phone;
    private String createdAt;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    private String updatedAt;

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getRecordId() {
        return recordId;
    }

    public int getFromId() {
        return fromId;
    }

    public int getToId() {
        return toId;
    }

    public int getStat() {
        return stat;
    }

    public String getRealname() {
        return realname;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "RecordAuth{" +
                "recordId=" + recordId +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", stat=" + stat +
                ", realname='" + realname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
