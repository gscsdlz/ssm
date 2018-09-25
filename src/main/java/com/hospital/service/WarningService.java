package com.hospital.service;

import com.hospital.entity.Warning;

import java.util.List;
import java.util.Map;

public interface WarningService {
    List<Warning> getWarning(int accountId, int page, int total);

    int getTotal(int accountId);

    void updateRows(List<String[]> args);

    void updateRow(int warningId, String keyName, float minVal, float maxVal);

    List<Integer> delRows(String[] args);

    Map<Integer, String> addRow(String[] info, int accountId);
}
