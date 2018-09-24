package com.hospital.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.dao.HealthDataDao;
import com.hospital.dao.WarningDao;
import com.hospital.entity.*;
import com.hospital.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WarningServiceImpl implements WarningService {

    @Autowired
    private WarningDao warningDao;

    @Autowired
    private HealthDataDao healthDataDao;

    @Override
    public List<Warning> getWarning(int accountId, int page, int total) {
        int p = (page - 1) * total;
        return warningDao.getWarning(accountId, p, total);
    }

    @Override
    public int getTotal(int accountId) {
        return warningDao.getWaringTotal(accountId);
    }

    @Override
    public void updateRows(List<String[]> args) {
        for (String[] strings : args) {
            updateRow(Integer.parseInt(strings[0]), strings[1], Float.parseFloat(strings[2]), Float.parseFloat(strings[3]));
        }
    }

    public void updateRow(int warningId, String keyName, float minVal, float maxVal) {
        warningDao.updateWarningRow(warningId, keyName, minVal, maxVal);
    }

    @Override
    public List<Integer> delRows(String[] args) {

        List<Integer> ids = new ArrayList<>();
        for (String s : args) {
            warningDao.delWarningRow(Integer.parseInt(s));
            ids.add(Integer.parseInt(s));
        }
        return ids;
    }

    @Override
    public Map<Integer, String> addRow(String[] info, int accountId) {

        Map<Integer, String> errors = new HashMap<>();
        String keyName = info[0];
        if (info[1].equals("")) {
            errors.put(1, "最小值不能为空");
        } else if (info[2].equals("")) {
            errors.put(2, "最大值不能为空");
        } else {
            float minVal = Float.parseFloat(info[1]);
            float maxVal = Float.parseFloat(info[2]);

            if (minVal > maxVal) {
                errors.put(2, "最大值不能小于最小值");
            } else {
                warningDao.addWarningRow(keyName, minVal, maxVal, accountId);
            }
        }
        return errors;
    }

    @Override
    public List<Alarm> getAlarm(int accountId) {
        List<Warning> list = warningDao.getWarnings(accountId);
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
        return res;
    }
}
