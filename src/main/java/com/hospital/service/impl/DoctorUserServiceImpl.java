package com.hospital.service.impl;

import com.hospital.dao.DoctorUserDao;
import com.hospital.entity.DoctorUser;
import com.hospital.service.DoctorUserService;
import com.hospital.utils.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorUserServiceImpl implements DoctorUserService {

    @Autowired
    private DoctorUserDao doctorUserDao;

    @Override
    public DoctorUser getDoctorUser(int accountId) {
        return doctorUserDao.getDoctorUser(accountId);
    }

    @Override
    public List<DoctorUser> getAllDoctors() {
        return doctorUserDao.getAllDoctors();
    }

    @Override
    public int updateUser(DoctorUser user) {
        return doctorUserDao.updateDoctorUser(user.getAccountId(), user.getRealname(),user.getAddress(),
                user.getPhone(), user.getHospitalName(),
                user.getSection(), user.getGenderInt(),
                user.getAge(), DateTime.dateNow());
    }

    @Override
    public int addDoctorUser(int accountId, String realname) {
        return doctorUserDao.addDoctorUser(accountId, realname);
    }

}
