package com.hospital.service;

import com.hospital.entity.FamilyUser;

public interface FamilyUserService {
    int addFamilyUser(int accountId, String username);

    FamilyUser getFamilyUser(int accountId);

    int updateUser(FamilyUser user);
}
