package com.hospital.service.impl;

import com.hospital.dao.ElderUserDao;
import com.hospital.entity.ElderUser;
import com.hospital.service.ElderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElderUserServiceImpl implements ElderUserService {

    @Autowired
    private ElderUserDao elderUserDao;

    @Override
    public boolean addUser(int accountId) {
        return elderUserDao.addUser(accountId);
    }

    @Override
    public ElderUser getElderUser(int accountId) {
        return elderUserDao.getElderUser(accountId);
    }

    @Override
    public int updateUser(ElderUser user) {
        return elderUserDao.updateElderUser(
                user.getAccountId(),
                user.getRealname(),
                user.getGender(),
                user.getBirth(),
                user.getAddress(),
                user.getPhone(),
                user.getIdCard(),
                user.getSsId(),
                user.getHasAllergy().equals("有") ? 1 : 0,
                user.getHasTrauma().equals("有") ? 1 : 0,
                user.getHasOperation().equals("有") ? 1 : 0,
                user.getHasInheritance().equals("有") ? 1 : 0);
    }
}
