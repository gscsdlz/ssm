package com.hospital.dao;

import com.hospital.entity.RecordAuth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordAuthDao {
    int addRecord(@Param("from_id") int fromId, @Param("to_id") int toId);

    List<RecordAuth> getRecords(@Param("from_id") int accountId);

    List<RecordAuth> getRecordsTo(@Param("to_id") int accountId);

    int recordStatChange(@Param("record_id") int recordId, @Param("stat") int stat);
}
