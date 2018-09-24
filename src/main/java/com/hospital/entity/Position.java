package com.hospital.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Position {
    private int id;
    private String createdAt;
    private String gpsData;
    private List<GPSInfo> list;

    public void setId(int id) {
        this.id = id;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setGpsData(String gpsData) {
        this.gpsData = gpsData;
    }

    public int getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getGpsData() {
        return gpsData;
    }

    public List<GPSInfo> getList() {
        return list;
    }

    public void handleJSON() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            list = mapper.readValue(gpsData, new TypeReference<List<GPSInfo>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
