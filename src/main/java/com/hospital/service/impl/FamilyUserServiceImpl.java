package com.hospital.service.impl;

import com.hospital.dao.FamilyUserDao;
import com.hospital.service.FamilyUserService;
import com.sun.xml.internal.ws.developer.UsesJAXBContext;
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
}
