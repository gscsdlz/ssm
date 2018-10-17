package com.hospital.dao;

import org.apache.ibatis.annotations.Param;

public interface GroupUserDao {
    int addGroupUser(@Param("account_id") int accountId, @Param("realname") String realname);
}
