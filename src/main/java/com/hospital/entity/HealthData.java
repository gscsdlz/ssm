package com.hospital.entity;

public class HealthData {
    private int dataId;
    private String data;
    private int type;
    private String createdAt;

    public static int HTYPE_BLOOD_PRESSURE = 1;
    public static int HTYPE_BLOOD_SUGAR = 2;
    public static int HTYPE_HEIGHT_WEIGHT = 3;

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setType(int type) {
        this.type = type;
    }


    public int getDataId() {
        return dataId;
    }

    public String getData() {
        return data;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public int getType() {
        return type;
    }

}
