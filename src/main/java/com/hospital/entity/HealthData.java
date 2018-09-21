package com.hospital.entity;

public class HealthData {
    private int dataId;
    private String data;
    private int type;
    private String created_at;

    public static  int HTYPE_BLOOD_PRESSURE = 1;

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getDataId() {
        return dataId;
    }

    public String getData() {
        return data;
    }

    public int getType() {
        return type;
    }

    public String getCreated_at() {
        return created_at;
    }
}
