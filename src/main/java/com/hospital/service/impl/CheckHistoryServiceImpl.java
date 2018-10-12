package com.hospital.service.impl;

import com.hospital.dao.CheckHistoryDao;
import com.hospital.dao.SickHistoryDao;
import com.hospital.entity.CheckHistory;
import com.hospital.entity.SickHistory;
import com.hospital.service.CheckHistoryService;
import com.hospital.service.SickHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckHistoryServiceImpl implements CheckHistoryService {

    @Autowired
    private CheckHistoryDao checkHistoryDao;

    @Override
    public List<CheckHistory> getAllCH(int accountId) {
        return checkHistoryDao.getAllCH(accountId);
    }

    @Override
    public int countChecks(int accountId) {
        return checkHistoryDao.countChecks(accountId);
    }
}
