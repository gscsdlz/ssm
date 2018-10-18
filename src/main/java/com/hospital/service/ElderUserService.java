package com.hospital.service;


import com.hospital.entity.ElderUser;

import java.util.List;

public interface ElderUserService {
    int addElderUser(int accountId, String username);

    ElderUser getElderUser(int accountId);

    int updateUser(ElderUser user);

    List<ElderUser> getElderUserByRealnameOrPhone(String realname, String phone);

    ElderUser getElderUserByIdCard(String idCard);
}
