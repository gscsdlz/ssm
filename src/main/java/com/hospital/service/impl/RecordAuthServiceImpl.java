package com.hospital.service.impl;

import com.hospital.dao.RecordAuthDao;
import com.hospital.entity.RecordAuth;
import com.hospital.service.RecordAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordAuthServiceImpl implements RecordAuthService {

    @Autowired
    private RecordAuthDao recordAuthDao;

    @Override
    public int addRecordAuth(int fromId, int toId) {
        return recordAuthDao.addRecord(fromId, toId);
    }

    @Override
    public List<RecordAuth> getRecords(int accountId) {
        return recordAuthDao.getRecords(accountId);
    }
}
