package com.hospital.dao;

import com.hospital.entity.Alarm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlarmDao {
    List<Alarm> getAlarm(@Param("account_id") int accountId);

    List<Alarm> getAlarmCase(@Param("account_id") int accountId, @Param("handle") int handle);

    List<Alarm> getAllAlarm();

    int doHandle(@Param("alarm_id") int alarmId, @Param("handle") int handle);

    int addAlarm(@Param("warning_id") int warningId, @Param("health_value") float healthValue, @Param("handle") int handle);

    int removeAlarm(@Param("warning_id") int warningId);
}
