package com.hospital.entity;

public class WorkOrder {
    private int orderId;
    private String elderName;
    private String accountId;
    private String groupName;
    private int elderId;
    private int type;
    private String content;
    private float price;
    private String serviceTime;
    private String createdAt;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getElderName() {
        return elderName;
    }

    public void setElderName(String elderName) {
        this.elderName = elderName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getElderId() {
        return elderId;
    }

    public void setElderId(int elderId) {
        this.elderId = elderId;
    }
}
