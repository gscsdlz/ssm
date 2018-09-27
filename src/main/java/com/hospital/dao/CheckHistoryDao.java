package com.hospital.dao;

import com.hospital.entity.CheckHistory;
import com.hospital.entity.SickHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckHistoryDao {
    List<CheckHistory> getAllCH(@Param("account_id") int account_id);
}
