package com.hospital.entity;

import java.util.HashMap;
import java.util.Map;

public class Alarm extends Warning {
    private int alarmId;
    private float healthValue;
    private String createdAt;
    private int handle;

    public void setAlarmId(int alarmId) {
        this.alarmId = alarmId;
    }

    public int getAlarmId() {
        return alarmId;
    }

    public void setHandle(int handle) {
        this.handle = handle;
    }

    public int getHandle() {
        return handle;
    }

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
        this.setCreatedAt(parent.getCreatedAt());
        this.setUsed(parent.getUsed());

        this.healthValue = healthValue;
        this.createdAt = date;
        this.handle = ALARM_UNHANDLE;
    }

    public void setHealthValue(float healthValue) {
        this.healthValue = healthValue;
    }

    public void setCreatedAt(String date) {
        this.createdAt = date;
    }

    public float getHealthValue() {
        return healthValue;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }
}
