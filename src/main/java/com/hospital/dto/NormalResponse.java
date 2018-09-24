package com.hospital.dto;

public class NormalResponse {
    private boolean status;
    private String info;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }
}
