package com.hospital.service;

import com.hospital.entity.Evaluate;

import java.util.List;
import java.util.Map;

public interface EvaluateService {
    List<Evaluate> getEvaluates(int accountId, int doctorId);

    List<Evaluate> getMyEvaluate(int accountId);

    int updateEvaluates(List<String[]> args);

    Map<Integer, String> addEvaluate(int accountId, int elderId, int evaluate, String suggest);

    List<Integer> delRows(String[] delList);

    int countEvaluate(int accountId);
}
