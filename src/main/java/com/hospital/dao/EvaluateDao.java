package com.hospital.dao;

import com.hospital.entity.Evaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluateDao {
    List<Evaluate> getEvaluates(@Param("account_id") int accountId, @Param("doctor_id") int doctorId);

    List<Evaluate> getMyEvaluates(@Param("account_id") int accountId);

    int delEvaluate(@Param("evaluate_id") int evaluateId);

    int updateEvaluate(@Param("evaluate_id") int evaluateId, @Param("evaluate") int evaluate, @Param("suggest") String suggest);

    int addEvaluate(@Param("doctor_id") int accountId, @Param("account_id") int elderId, @Param("evaluate") int evaluate, @Param("suggest") String suggest);
}
