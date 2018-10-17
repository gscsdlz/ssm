package com.hospital.service.impl;

import com.hospital.dao.GroupUserDao;
import com.hospital.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupUserServiceImpl implements GroupUserService {

    @Autowired
    private GroupUserDao groupUserDao;

    @Override
    public int addGroupUser(int accountId, String realname) {
        return groupUserDao.addGroupUser(accountId, realname);
    }
}
