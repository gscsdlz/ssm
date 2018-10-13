package com.hospital.dao;

import com.hospital.entity.DoctorUser;
import org.apache.ibatis.annotations.Param;

public interface DoctorUserDao {
    DoctorUser getDoctorUser(@Param("account_id") int accountId);
}
