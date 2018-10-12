package com.hospital.service;

import com.hospital.entity.DrugHistory;

import java.util.List;

public interface DrugHistoryService {
    List<DrugHistory> getAllDH(int accountId);

    int countDrugs(int accountId);
}
