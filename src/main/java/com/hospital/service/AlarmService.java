package com.hospital.service;

import com.hospital.entity.Alarm;

import java.util.List;

public interface AlarmService {

    void updateAlarm(int accountId);

    List<Alarm> getAlarm(int accountId);

    List<Alarm> getAlarm(int accountId, int handle);

    List<Alarm> getAlarmByDoctor(int doctorId);

    List<Alarm> getAlarmByFamily(int familyId);

    void doHandle(int alarmId, int handle);

    void removeAlarm(int accountId);
}
