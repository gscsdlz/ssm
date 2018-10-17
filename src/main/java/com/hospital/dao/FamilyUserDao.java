package com.hospital.dao;

import org.apache.ibatis.annotations.Param;

public interface FamilyUserDao {
    int addFamilyUser(@Param("account_id") int accountId, @Param("realname") String realname);
}
