package com.hospital.service;


import com.hospital.entity.ElderUser;

import java.util.List;

public interface ElderUserService {
    boolean addUser(int accountId);

    ElderUser getElderUser(int accountId);

    int updateUser(ElderUser user);

    List<ElderUser> getElderUserByRealnameOrPhone(String realname, String phone);
}
