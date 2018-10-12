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
    private DrugHistoryDao drugHistoryDao;

    @Override
    public List<DrugHistory> getAllDH(int accountId) {
        return drugHistoryDao.getAllDH(accountId);
    }

    @Override
    public int countDrugs(int accountId) {
        return drugHistoryDao.countDrugs(accountId);
    }
}
