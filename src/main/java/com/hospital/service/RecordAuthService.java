package com.hospital.service;

import com.hospital.entity.RecordAuth;

import java.util.List;

public interface RecordAuthService {
    int addRecordAuth(int fromId, int toId);

    List<RecordAuth> getRecords(int accountId);

    int recordStatChange(int recordId, int stat);

    List<RecordAuth> getRecordsTo(int accountId);
}
