package com.hospital.dao;

import com.hospital.entity.DoctorUser;
import com.hospital.entity.ElderUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConnectionDao {
    int addConnection(@Param("account_id") int accountId, @Param("doctor_id") int doctorId);

    int removeConnection(@Param("account_id") int accountId, @Param("doctor_id") int doctorId);

    List<DoctorUser> getMyDoctors(@Param("account_id") int accountId);

    int countDoctor(@Param("account_id") int accountId);

    List<ElderUser> getMyElders(@Param("doctor_id") int accountId);
}
