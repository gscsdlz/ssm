package com.hospital.service;

import com.hospital.entity.HealthData;

import java.util.List;

public interface HealthDataService {
    List<HealthData> getHealthData(int type, int account_id);

    List<HealthData> getHealthDataByDate(int type, int account_id, String l, String r);

    HealthData getLastHealthData(int type, int accountId);

    int countHealthData(int accountId);

    int countAllHealthData();
}
