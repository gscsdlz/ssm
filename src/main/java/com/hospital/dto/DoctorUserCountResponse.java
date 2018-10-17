package com.hospital.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DoctorUserCountResponse extends NormalResponse {
    private int elder;
    private int join;
    private int answers;
    private int evaluates;

    public void setElder(int elder) {
        this.elder = elder;
    }

    public void setJoin(int join) {
        this.join = join;
    }

    public void setAnswers(int answers) {
        this.answers = answers;
    }

    public void setEvaluates(int evaluates) {
        this.evaluates = evaluates;
    }

    public int getElder() {
        return elder;
    }

    public int getJoin() {
        return join;
    }

    public int getAnswers() {
        return answers;
    }

    public int getEvaluates() {
        return evaluates;
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
