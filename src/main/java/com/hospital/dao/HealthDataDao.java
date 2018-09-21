package com.hospital.dao;

import com.hospital.entity.HealthData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HealthDataDao {
    List<HealthData> getHealthData(@Param("type") int type, @Param("account_id") int account_id);

    List<HealthData> getHealthDataByDate(@Param("type") int type, @Param("account_id") int account_id, @Param("l") String l, @Param("r") String r);
}
