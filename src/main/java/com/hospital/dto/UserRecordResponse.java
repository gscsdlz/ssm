package com.hospital.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.entity.BloodPressure;
import com.hospital.entity.BloodSugar;
import com.hospital.entity.HeightWeight;

public class UserRecordResponse extends NormalResponse {
    private BloodPressure bloodPressure;
    private BloodSugar bloodSugar;
    private HeightWeight heightWeight;

    public BloodPressure getBloodPressure() {
        return bloodPressure;
    }

    public BloodSugar getBloodSugar() {
        return bloodSugar;
    }

    public HeightWeight getHeightWeight() {
        return heightWeight;
    }

    public void setBloodPressure(BloodPressure bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public void setBloodSugar(BloodSugar bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public void setHeightWeight(HeightWeight heightWeight) {
        this.heightWeight = heightWeight;
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
