package com.hospital.service;

import com.hospital.entity.Account;

public interface AccountService {
    Account getUserByUsername(String username);

    int addUser(String username, String password, int act);

    int countJoin(int accountId);

    int disable(int accountId, int disable);

    int resetPassword(int accountId);
}
