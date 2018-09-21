package com.hospital.service.impl;

import com.hospital.dao.ElderUserDao;
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
}
