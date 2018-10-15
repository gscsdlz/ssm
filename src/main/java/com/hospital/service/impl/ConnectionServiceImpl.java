package com.hospital.service.impl;

import com.hospital.dao.ConnectionDao;
import com.hospital.entity.DoctorUser;
import com.hospital.entity.ElderUser;
import com.hospital.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Autowired
    private ConnectionDao connectionDao;

    @Override
    public int addConnection(int accountId, int doctorId) {
        return connectionDao.addConnection(accountId, doctorId);
    }

    @Override
    public int removeConnection(int accountId, int doctorId) {
        return connectionDao.removeConnection(accountId, doctorId);
    }


    @Override
    public List<DoctorUser> getMyDoctors(int accountId) {
        return connectionDao.getMyDoctors(accountId);
    }

    @Override
    public int countDoctor(int accountId) {
        return connectionDao.countDoctor(accountId);
    }

    @Override
    public List<ElderUser> getMyElders(int accountId) {
        return connectionDao.getMyElders(accountId);
    }
}
