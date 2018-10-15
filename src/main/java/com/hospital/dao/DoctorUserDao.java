package com.hospital.dao;

import com.hospital.entity.DoctorUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoctorUserDao {
    DoctorUser getDoctorUser(@Param("account_id") int accountId);

    List<DoctorUser> getAllDoctors();
}
