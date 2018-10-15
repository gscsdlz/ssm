package com.hospital.service.impl;

import com.hospital.dao.ConnectionDao;
import com.hospital.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
