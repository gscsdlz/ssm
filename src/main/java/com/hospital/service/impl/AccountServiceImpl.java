package com.hospital.service.impl;

import com.hospital.dao.AccountDao;
import com.hospital.entity.Account;
import com.hospital.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account getUserByUsername(String usename) {
        return accountDao.getUserByUsername(usename);
    }

    @Override
    public int addUser(String username, String password, int act) {
        return accountDao.addUser(username, password, act);
    }

    @Override
    public int countJoin(int accountId) {
        return accountDao.countJoin(accountId);
    }
}
