package com.hospital.dao;

import com.hospital.entity.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountDao {
    Account getUserByUsername(String username);

    int addUser(@Param("username") String username, @Param("password") String password, @Param("act") int act);
}
