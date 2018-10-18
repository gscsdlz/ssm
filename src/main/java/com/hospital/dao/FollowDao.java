package com.hospital.dao;

import com.hospital.entity.ElderUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FollowDao {
    List<ElderUser> getHomeElders(@Param("family_id") int familyId);

    int addHomeElder(@Param("family_id") int familyId, @Param("account_id") int accountId);

    int removeHomeElder(@Param("family_id") int familyId, @Param("account_id") int accountId);

}
