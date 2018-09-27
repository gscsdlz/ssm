package com.hospital.entity;

public class SickHistory {
    private int shId;
    private String hospitalName;
    private String section;
    private String result;
    private String realName;
    private String method;
    private String createdAt;

    public void setShId(int shId) {
        this.shId = shId;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getShId() {
        return shId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getSection() {
        return section;
    }

    public String getResult() {
        return result;
    }

    public String getRealName() {
        return realName;
    }

    public String getMethod() {
        return method;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
