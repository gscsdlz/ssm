package com.hospital.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.dao.AlarmDao;
import com.hospital.dao.ConnectionDao;
import com.hospital.dao.HealthDataDao;
import com.hospital.dao.WarningDao;
import com.hospital.entity.*;
import com.hospital.service.AlarmService;
import com.sun.org.apache.bcel.internal.generic.ALOAD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlarmServiceImpl implements AlarmService {

    @Autowired
    private AlarmDao alarmDao;

    @Autowired
    private WarningDao warningDao;

    @Autowired
    private HealthDataDao healthDataDao;

    @Autowired
    private ConnectionDao connectionDao;

    @Override
    public void updateAlarm(int accountId) {
        List<Warning> list = warningDao.getWarningForAlarm(accountId);
        List<HealthData> list1 = healthDataDao.getHealthData(HealthData.HTYPE_HEIGHT_WEIGHT, accountId);
        List<HealthData> list2 = healthDataDao.getHealthData(HealthData.HTYPE_BLOOD_PRESSURE, accountId);
        List<HealthData> list3 = healthDataDao.getHealthData(HealthData.HTYPE_BLOOD_SUGAR, accountId);

        List<HeightWeight> hwList = new ArrayList<>();
        List<BloodPressure> bpList = new ArrayList<>();
        List<BloodSugar> bsList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        for (HealthData data : list1) {
            try {
                HeightWeight t = mapper.readValue(data.getData(), HeightWeight.class);
                hwList.add(t);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        for (HealthData data : list2) {
            try {
                BloodPressure t = mapper.readValue(data.getData(), BloodPressure.class);
                bpList.add(t);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        for (HealthData data : list3) {
            try {
                BloodSugar t = mapper.readValue(data.getData(), BloodSugar.class);
                bsList.add(t);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        List<Alarm> res = new ArrayList<>();
        for(Warning w : list) {
            String key = w.getKeyName();
            float minVal = w.getMinVal();
            float maxVal = w.getMaxVal();

            switch (key) {
                case "systolic": {
                    for (BloodPressure bloodPressure : bpList) {
                        if (bloodPressure.getSystolic() < minVal || bloodPressure.getSystolic() > maxVal) {
                            res.add(new Alarm(w, bloodPressure.getSystolic(), bloodPressure.getDate()));
                        }
                    }
                }
                break;
                case "diastolic" : {
                    for (BloodPressure bloodPressure : bpList) {
                        if (bloodPressure.getDiastolic() < minVal || bloodPressure.getDiastolic() > maxVal) {
                            res.add(new Alarm(w, bloodPressure.getDiastolic(), bloodPressure.getDate()));
                        }
                    }
                } break;
                case "pulse" : {
                    for (BloodPressure bloodPressure : bpList) {
                        if (bloodPressure.getPulse() < minVal || bloodPressure.getPulse() > maxVal) {
                            res.add(new Alarm(w, bloodPressure.getPulse(), bloodPressure.getDate()));
                        }
                    }
                } break;
                case "value" : {
                    for (BloodSugar bloodSugar : bsList) {
                        if (bloodSugar.getValue() < minVal || bloodSugar.getValue() > maxVal) {
                            res.add(new Alarm(w, bloodSugar.getValue(), bloodSugar.getDate()));
                        }
                    }
                } break;
                case "height" : {
                    for (HeightWeight heightWeight : hwList) {
                        if (heightWeight.getHeight() < minVal || heightWeight.getHeight() > maxVal) {
                            res.add(new Alarm(w, heightWeight.getHeight(), heightWeight.getDate()));
                        }
                    }
                } break;
                case "weight" : {
                    for (HeightWeight heightWeight : hwList) {
                        if (heightWeight.getWeight() < minVal || heightWeight.getWeight() > maxVal) {
                            res.add(new Alarm(w, heightWeight.getWeight(), heightWeight.getDate()));
                        }
                    }
                } break;
                case "bmi" : {
                    for (HeightWeight heightWeight : hwList) {
                        if (heightWeight.getBmi() < minVal || heightWeight.getBmi() > maxVal) {
                            res.add(new Alarm(w, heightWeight.getBmi(), heightWeight.getDate()));
                        }
                    }
                } break;
            }
        }
        for(Alarm a : res) {
            alarmDao.addAlarm(a.getWarningId(), a.getHealthValue(), a.getHandle());
            warningDao.checkUsed(a.getWarningId(), 1);
        }
    }

    @Override
    public List<Alarm> getAlarm(int accountId) {
        return alarmDao.getAlarm(accountId);
    }

    public List<Alarm> getAlarm(int accountId, int handle) {
        return alarmDao.getAlarmCase(accountId, handle);
    }

    @Override
    public List<Alarm> getAlarmByDoctor(int doctorId) {
        List<Alarm> res = new ArrayList<>();
        List<ElderUser> users = connectionDao.getMyElders(doctorId);

        for (ElderUser user : users) {
            List<Alarm> t = alarmDao.getAlarmCase(user.getAccountId(), Alarm.ALARM_UNHANDLE);
            res.addAll(t);
        }
        return res;
    }

    @Override
    public void doHandle(int alarmId, int handle) {
        alarmDao.doHandle(alarmId, handle);
    }

    @Override
    public void removeAlarm(int accountId) {
        List<Integer> ids = warningDao.getUsedPrepare(accountId);
        for(int id : ids) {
            warningDao.checkUsed(id, 0);
            alarmDao.removeAlarm(id);
        }
    }
}
