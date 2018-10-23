package com.hospital.dao;

import com.hospital.entity.GroupUser;
import org.apache.ibatis.annotations.Param;

public interface GroupUserDao {
    int addGroupUser(@Param("account_id") int accountId, @Param("realname") String realname);

    int updateGroupUser(
            @Param("account_id") int acccountId,
            @Param("realname") String realname,
            @Param("phone") String phone,
            @Param("address") String address,
            @Param("updated_at") String updatedAt);

    GroupUser getGroupUserById(@Param("account_id") int accountId);
}
