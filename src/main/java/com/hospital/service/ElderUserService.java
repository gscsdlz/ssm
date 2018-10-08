package com.hospital.service;


import com.hospital.entity.ElderUser;

public interface ElderUserService {
    boolean addUser(int accountId);

    ElderUser getElderUser(int accountId);

    int updateUser(ElderUser user);
}
