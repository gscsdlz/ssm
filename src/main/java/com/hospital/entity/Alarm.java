package com.hospital.entity;

import java.util.HashMap;
import java.util.Map;

public class Alarm extends Warning {
    private float healthValue;
    private String date;

    public static int ALARM_UNHANDLE = 0;
    public static int ALARM_HANDLE = 1;

    public Alarm() {

    }


    public Alarm(Warning parent, float healthValue, String date) {
        super();
        this.setWarningId(parent.getWarningId());
        this.setKeyName(parent.getKeyName());
        this.setMinVal(parent.getMinVal());
        this.setMaxVal(parent.getMaxVal());
        this.setHandle(parent.getHandle());
        this.setCreatedAt(parent.getCreatedAt());

        this.healthValue = healthValue;
        this.date = date;
    }

    public void setHealthValue(float healthValue) {
        this.healthValue = healthValue;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getHealthValue() {
        return healthValue;
    }

    public String getDate() {
        return date;
    }
}
