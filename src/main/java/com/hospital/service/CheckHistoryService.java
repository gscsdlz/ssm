package com.hospital.service;

import com.hospital.entity.CheckHistory;
import com.hospital.entity.SickHistory;

import java.util.List;

public interface CheckHistoryService {
    List<CheckHistory> getAllCH(int accountId);
}
