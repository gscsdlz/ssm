package com.hospital.service;

import com.hospital.entity.GroupUser;

public interface GroupUserService {
    int addGroupUser(int accountId, String realname);

    int updateGroupUser(int accountId, String realname, String phone, String address);

    GroupUser getUserById(int accountId);
}
