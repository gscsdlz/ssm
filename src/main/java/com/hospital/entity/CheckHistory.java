package com.hospital.entity;

public class CheckHistory {
    private int chId;
    private String hospitalName;
    private String section;
    private String checkName;
    private String checkReason;
    private String realName;

    public void setSection(String section) {
        this.section = section;
    }

    public void setChId(int chId) {
        this.chId = chId;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public void setCheckReason(String checkReason) {
        this.checkReason = checkReason;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getSection() {
        return section;
    }

    public int getChId() {
        return chId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getCheckName() {
        return checkName;
    }

    public String getCheckReason() {
        return checkReason;
    }

    public String getRealName() {
        return realName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    private String createdAt;

}
