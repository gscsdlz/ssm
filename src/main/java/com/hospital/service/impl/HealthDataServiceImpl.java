package com.hospital.service.impl;

import com.hospital.dao.HealthDataDao;
import com.hospital.entity.HealthData;
import com.hospital.service.HealthDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthDataServiceImpl implements HealthDataService {

    @Autowired
    private HealthDataDao healthDataDao;

    @Override
    public List<HealthData> getHealthData(int type, int account_id) {
        return healthDataDao.getHealthData(type, account_id);
    }

    @Override
    public List<HealthData> getHealthDataByDate(int type, int account_id, String l, String r) {
        return healthDataDao.getHealthDataByDate(type, account_id, l ,r);
    }

    @Override
    public HealthData getLastHealthData(int type, int accountId) {
        return healthDataDao.getLastHealthData(type, accountId);
    }

    @Override
    public int countHealthData(int accountId) {
        return healthDataDao.countHealthData(accountId);
    }
}
