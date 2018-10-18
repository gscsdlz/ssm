package com.hospital.service;

import com.hospital.entity.ElderUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FollowService {
    List<ElderUser> getHomeElders(int familyId);

    int addHomeElder(int familyId, int accountId);

    int removeHomeElder(int familyId, int accountId);
}
