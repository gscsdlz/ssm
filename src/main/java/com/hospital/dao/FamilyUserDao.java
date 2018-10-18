package com.hospital.dao;

import com.hospital.entity.FamilyUser;
import org.apache.ibatis.annotations.Param;

public interface FamilyUserDao {
    int addFamilyUser(@Param("account_id") int accountId, @Param("realname") String realname);

    FamilyUser getFamilyUser(@Param("account_id") int accountId);

    int updateFamilyUser(
            @Param("account_id") int accountId,
            @Param("realname") String realname,
            @Param("phone") String phone,
            @Param("address") String address,
            @Param("updated_at") String dateNow);
}
