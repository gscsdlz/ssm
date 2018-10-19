package com.hospital.dao;

import com.hospital.entity.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountDao {
    Account getUserByUsername(String username);

    int addUser(@Param("username") String username, @Param("password") String password, @Param("act") int act);

    int countJoin(@Param("account_id") int accountId);

    int disable(@Param("account_id") int accountId, @Param("disable") int disable);

    int resetPassword(@Param("account_id") int accountId);
}
