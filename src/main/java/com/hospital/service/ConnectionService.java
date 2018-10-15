package com.hospital.service;

import com.hospital.entity.DoctorUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConnectionService {
    int addConnection(@Param("account_id") int accountId, @Param("doctor_id") int doctorId);

    int removeConnection(int accountId, int doctorId);

    List<DoctorUser> getMyDoctors(int accountId);

    int countDoctor(int accountId);
}
