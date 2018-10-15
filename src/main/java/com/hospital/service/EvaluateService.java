package com.hospital.service;

import com.hospital.entity.Evaluate;

import java.util.List;

public interface EvaluateService {
    List<Evaluate> getAllEvaluates(int doctorId);

    List<Evaluate> getEvaluate(int accountId);

    int delEvaluate(int evaluateId);

    int updateEvalute(int evaluteId, String suggest);
}
