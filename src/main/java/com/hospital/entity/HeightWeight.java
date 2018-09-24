package com.hospital.entity;

public class HeightWeight {
    private String date;
    private float height;
    private float weight;
    private float bmi;

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public String getDate() {
        return date;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public float getBmi() {
        return bmi;
    }
}
