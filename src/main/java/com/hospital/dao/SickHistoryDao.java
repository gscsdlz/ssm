package com.hospital.dao;

import com.hospital.entity.SickHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SickHistoryDao {
    List<SickHistory> getAllSH(@Param("account_id") int account_id);

    int countSicks(@Param("account_id") int accountId);
}
