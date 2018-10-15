package com.hospital.dao;

import com.hospital.entity.Evaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluateDao {
    List<Evaluate> getAllEvaluates(@Param("doctor_id") int doctorId);

    List<Evaluate> getEvaluate(@Param("account_id") int accountId);

    int delEvaluate(@Param("evaluate_id") int evaluateId);

    int updateEvalute(@Param("evaluate_id") int evaluateId, @Param("suggest") String suggest);
}
