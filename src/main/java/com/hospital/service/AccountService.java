package com.hospital.service;

import com.hospital.entity.Account;

public interface AccountService {
    Account getUserByUsername(String username);

    int addUser(String username, String password, int act);
}
