package com.hospital.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class IndexCountResponse extends NormalResponse {
    private int healthData;
    private int workOrders;
    private int complaints;
    private int doctors;

    public int getHealthData() {
        return healthData;
    }

    public void setHealthData(int healthData) {
        this.healthData = healthData;
    }

    public int getWorkOrders() {
        return workOrders;
    }

    public void setWorkOrders(int workOrders) {
        this.workOrders = workOrders;
    }

    public int getComplaints() {
        return complaints;
    }

    public void setComplaints(int complaints) {
        this.complaints = complaints;
    }

    public int getDoctors() {
        return doctors;
    }

    public void setDoctors(int doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            return "";
        }
    }
}
