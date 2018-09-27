package com.hospital.service.impl;

import com.hospital.dao.DrugHistoryDao;
import com.hospital.entity.DrugHistory;
import com.hospital.service.DrugHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugHistoryServiceImpl implements DrugHistoryService {

    @Autowired
    private DrugHistoryDao checkHistoryDao;

    @Override
    public List<DrugHistory> getAllDH(int accountId) {
        return checkHistoryDao.getAllDH(accountId);
    }
}
