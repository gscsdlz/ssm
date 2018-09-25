package com.hospital.dao;

import com.hospital.entity.Warning;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarningDao {
    List<Warning> getWarning(@Param("account_id") int accountId, @Param("page") int page, @Param("total") int total);

    List<Warning> getWarnings(@Param("account_id") int accountId);

    List<Warning> getWarningForAlarm(@Param("account_id") int accountId);

    int getWaringTotal(@Param("account_id") int accountId);

    void updateWarningRow(@Param("warning_id") int warningId, @Param("key_name") String keyName, @Param("min_val") float minVal, @Param("max_val") float maxVal);

    void delWarningRow(@Param("warning_id") int warningId);

    void addWarningRow(@Param("key_name") String keyName, @Param("min_val") float minVal, @Param("max_val") float maxVal, @Param("account_id") int accountId);

    void checkUsed(@Param("warning_id") int warningId, @Param("used") int used);

    List<Integer> getUsedPrepare(@Param("account_id") int accountId);

}
