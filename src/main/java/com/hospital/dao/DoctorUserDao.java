package com.hospital.dao;

import com.hospital.entity.DoctorUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoctorUserDao {
    DoctorUser getDoctorUser(@Param("account_id") int accountId);

    List<DoctorUser> getAllDoctors();

    int updateDoctorUser(
            @Param("account_id") int accountId,
            @Param("realname") String realname,
            @Param("address") String address,
            @Param("phone") String phone,
            @Param("hospital_name") String name,
            @Param("section") String section,
            @Param("gender") int gender,
            @Param("age") int age,
            @Param("updated_at") String date
    );
}
