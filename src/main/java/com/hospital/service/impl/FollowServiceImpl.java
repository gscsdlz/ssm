package com.hospital.service.impl;

import com.hospital.dao.FollowDao;
import com.hospital.entity.ElderUser;
import com.hospital.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowDao followDao;

    @Override
    public List<ElderUser> getHomeElders(int familyId) {
        return followDao.getHomeElders(familyId);
    }

    @Override
    public int addHomeElder(int familyId, int accountId) {
        return followDao.addHomeElder(familyId, accountId);
    }

    @Override
    public int removeHomeElder(int familyId, int accountId) {
        return followDao.removeHomeElder(familyId, accountId);
    }
}
