package com.hospital.service.impl;

import com.hospital.dao.AccountDao;
import com.hospital.entity.Account;
import com.hospital.service.AccountService;
import com.hospital.utils.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account getUserByUsername(String username) {
        return accountDao.getUserByUsername(username);
    }

    @Override
    public int addUser(String username, String password, int act) {
        return accountDao.addUser(username, password, act);
    }

    @Override
    public int countJoin(int accountId) {
        return accountDao.countJoin(accountId);
    }

    @Override
    public int disable(int accountId, int disable) {
        return accountDao.disable(accountId, disable);
    }

    @Override
    public int resetPassword(int accountId) {
        return accountDao.resetPassword(accountId);
    }

    @Override
    public List<Account> getAllUser() {
        return accountDao.getAllAccount();
    }
}
