package com.hospital.service.impl;

import com.hospital.dao.GroupUserDao;
import com.hospital.entity.GroupUser;
import com.hospital.service.GroupUserService;
import com.hospital.utils.DateTime;
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

    @Override
    public int updateGroupUser(int accountId, String realname, String phone, String address) {
        return groupUserDao.updateGroupUser(accountId, realname, phone, address, DateTime.dateNow());
    }

    @Override
    public GroupUser getUserById(int accountId) {
        return groupUserDao.getGroupUserById(accountId);
    }
}
