package com.hospital.service;

import com.hospital.entity.SickHistory;

import java.util.List;

public interface SickHistoryService {
    List<SickHistory> getAllSH(int accountId);

    int countSicks(int accountId);
}
