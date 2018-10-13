package com.hospital.service.impl;

import com.hospital.dao.DoctorUserDao;
import com.hospital.entity.DoctorUser;
import com.hospital.service.DoctorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorUserServiceImpl implements DoctorUserService {

    @Autowired
    private DoctorUserDao doctorUserDao;

    @Override
    public DoctorUser getDoctorUser(int accountId) {
        return doctorUserDao.getDoctorUser(accountId);
    }
}
