package com.hospital.service;

import org.apache.ibatis.annotations.Param;

public interface ConnectionService {
    int addConnection(@Param("account_id") int accountId, @Param("doctor_id") int doctorId);

    int removeConnection(int accountId, int doctorId);
}
