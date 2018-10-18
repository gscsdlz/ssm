package com.hospital.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FamilyUserCountResponse extends NormalResponse {
    private int join;
    private int follows;

    public void setJoin(int join) {
        this.join = join;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public int getJoin() {
        return join;
    }

    public int getFollows() {
        return follows;
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
