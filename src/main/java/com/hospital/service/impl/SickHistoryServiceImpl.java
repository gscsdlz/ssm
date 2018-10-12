package com.hospital.service.impl;

import com.hospital.dao.SickHistoryDao;
import com.hospital.entity.SickHistory;
import com.hospital.service.SickHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SickHistoryServiceImpl implements SickHistoryService {

    @Autowired
    private SickHistoryDao sickHistoryDao;

    @Override
    public List<SickHistory> getAllSH(int accountId) {
        return sickHistoryDao.getAllSH(accountId);
    }

    @Override
    public int countSicks(int accountId) {
        return sickHistoryDao.countSicks(accountId);
    }
}
