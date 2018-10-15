package com.hospital.service;


import com.hospital.entity.DoctorUser;
import com.hospital.entity.ElderUser;

import java.util.List;

public interface DoctorUserService {
    DoctorUser getDoctorUser(int accountId);

    List<DoctorUser> getAllDoctors();
}
