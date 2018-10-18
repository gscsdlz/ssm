package com.hospital.service.impl;

import com.hospital.dao.FamilyUserDao;
import com.hospital.entity.FamilyUser;
import com.hospital.service.FamilyUserService;
import com.hospital.utils.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyUserServiceImpl implements FamilyUserService {

    @Autowired
    private FamilyUserDao familyUserDao;

    @Override
    public int addFamilyUser(int accountId, String username) {
        return familyUserDao.addFamilyUser(accountId, username);
    }

    @Override
    public FamilyUser getFamilyUser(int accountId) {
        return familyUserDao.getFamilyUser(accountId);
    }

    @Override
    public int updateUser(FamilyUser user) {
        return familyUserDao.updateFamilyUser(user.getAccountId(), user.getRealname(), user.getPhone(), user.getAddress(), DateTime.dateNow());
    }
}
