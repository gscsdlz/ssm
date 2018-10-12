package com.hospital.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ElderUserCountResponse extends NormalResponse {
    private int healthDataCount;
    private int join;
    private int sicks;
    private int checks;
    private int drugs;
    private int doctor;

    public void setHealthDataCount(int healthDataCount) {
        this.healthDataCount = healthDataCount;
    }

    public void setJoin(int join) {
        this.join = join;
    }

    public void setSicks(int sicks) {
        this.sicks = sicks;
    }

    public void setChecks(int checks) {
        this.checks = checks;
    }

    public void setDrugs(int drugs) {
        this.drugs = drugs;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    public int getHealthDataCount() {
        return healthDataCount;
    }

    public int getJoin() {
        return join;
    }

    public int getSicks() {
        return sicks;
    }

    public int getChecks() {
        return checks;
    }

    public int getDrugs() {
        return drugs;
    }

    public int getDoctor() {
        return doctor;
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
