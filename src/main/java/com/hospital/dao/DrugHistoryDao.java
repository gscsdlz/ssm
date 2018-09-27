package com.hospital.dao;

import com.hospital.entity.CheckHistory;
import com.hospital.entity.DrugHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DrugHistoryDao {
    List<DrugHistory> getAllDH(@Param("account_id") int account_id);
}
