package com.hospital.entity;

public class BloodSugar {
    private String date;
    private float value;
    private int duration;

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }

    public String toString() {
        return date + ": 血糖值：" + value + " 时间差：" + duration;
    }
}
