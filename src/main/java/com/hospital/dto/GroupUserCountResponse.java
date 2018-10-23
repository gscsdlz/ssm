package com.hospital.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GroupUserCountResponse extends NormalResponse {
    private int join;
    private int complaints;
    private int workOrders;

    public int getComplaints() {
        return complaints;
    }

    public void setComplaints(int complaints) {
        this.complaints = complaints;
    }

    public int getWorkOrders() {
        return workOrders;
    }

    public void setWorkOrders(int workOrders) {
        this.workOrders = workOrders;
    }

    public void setJoin(int join) {
        this.join = join;
    }


    public int getJoin() {
        return join;
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
