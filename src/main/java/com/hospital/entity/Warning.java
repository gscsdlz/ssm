package com.hospital.entity;

import java.util.HashMap;
import java.util.Map;

public class Warning {
    private int warningId;
    private String keyName;
    private float minVal;
    private float maxVal;
    private String createdAt;
    private int used;

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountId() {
        return accountId;
    }

    private int accountId;

    public void setUsed(int used) {
        this.used = used;
    }

    public int getUsed() {
        return used;
    }

    public static Map<String, String> keyNames;
    static {
        keyNames = new HashMap<>();
        keyNames.put("systolic", "收缩压（mmHg）");
        keyNames.put("diastolic", "舒张压（mmHg）");
        keyNames.put("value", "血糖");
        keyNames.put("height", "身高（cm）");
        keyNames.put("weight", "体重（kg）");
        keyNames.put("bmi", "BMI指数");
    }

    public void setWarningId(int warningId) {
        this.warningId = warningId;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public void setMinVal(float minVal) {
        this.minVal = minVal;
    }

    public void setMaxVal(float maxVal) {
        this.maxVal = maxVal;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getWarningId() {
        return warningId;
    }

    public String getKeyName() {
        return keyName;
    }

    public float getMinVal() {
        return minVal;
    }

    public float getMaxVal() {
        return maxVal;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
