package com.hospital.dao;

import org.apache.ibatis.annotations.Param;

public interface ConnectionDao {
    int addConnection(@Param("account_id") int accountId, @Param("doctor_id") int doctorId);

    int removeConnection(@Param("account_id") int accountId, @Param("doctor_id") int doctorId);
}
