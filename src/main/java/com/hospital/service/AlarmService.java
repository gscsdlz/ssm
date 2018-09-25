package com.hospital.service;

import com.hospital.entity.Alarm;

import java.util.List;

public interface AlarmService {

    void updateAlarm(int accountId);

    List<Alarm> getAlarm(int accountId);

    List<Alarm> getAlarm(int accountId, int handle);

    void doHandle(int alarmId, int handle);

}
