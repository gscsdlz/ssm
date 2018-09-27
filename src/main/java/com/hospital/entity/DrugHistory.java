package com.hospital.entity;

import jdk.internal.dynalink.beans.StaticClass;

import java.util.HashMap;
import java.util.Map;

public class DrugHistory {
    private int dhId;
    private String hospitalName;
    private String drugName;
    private String totalSize;
    private String onceSize;
    private String unit;
    private int status;
    private String drugType;
    private String typeDetail;
    private String realName;
    private String createdAt;

    public static Map<Integer, String> drugTypeMap;

    static {
        drugTypeMap = new HashMap<>();
        drugTypeMap.put(1, "已结束");
        drugTypeMap.put(2, "正在使用");
        drugTypeMap.put(3, "轻微");
        drugTypeMap.put(4, "严重");
    }

    public void setDhId(int dhId) {
        this.dhId = dhId;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public void setTotalSize(String totalSize) {
        this.totalSize = totalSize;
    }

    public void setOnceSize(String onceSize) {
        this.onceSize = onceSize;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public void setTypeDetail(String typeDetail) {
        this.typeDetail = typeDetail;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getDhId() {
        return dhId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getDrugName() {
        return drugName;
    }

    public String getTotalSize() {
        return totalSize;
    }

    public String getOnceSize() {
        return onceSize;
    }

    public String getUnit() {
        return unit;
    }

    public String getStatus() {
        return drugTypeMap.get(status);
    }

    public String getDrugType() {
        return drugType;
    }

    public String getTypeDetail() {
        return typeDetail;
    }

    public String getRealName() {
        return realName;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
