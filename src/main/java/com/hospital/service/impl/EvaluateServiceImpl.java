package com.hospital.service.impl;

import com.hospital.dao.EvaluateDao;
import com.hospital.entity.Evaluate;
import com.hospital.entity.SickHistory;
import com.hospital.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private EvaluateDao evaluateDao;

    @Override
    public List<Evaluate> getEvaluates(int accountId, int doctorId) {
        return evaluateDao.getEvaluates(accountId, doctorId);
    }

    @Override
    public List<Evaluate> getMyEvaluate(int accountId) {
        return evaluateDao.getMyEvaluates(accountId);
    }

    @Override
    public int updateEvaluates(List<String[]> args) {
        int total = 0;
        for(String[] arg : args) {
            total += evaluateDao.updateEvaluate(Integer.parseInt(arg[0]), Integer.parseInt(arg[1]), arg[2]);
        }
        return total;
    }

    @Override
    public Map<Integer, String> addEvaluate(int accountId, int elderId, int evaluate, String suggest) {
        Map<Integer, String> errors = new HashMap<>();
        if (suggest.length() == 0) {
            errors.put(1, "意见不能为空");
        } else {
            evaluateDao.addEvaluate(accountId, elderId, evaluate, suggest);
        }
        return errors;
    }

    @Override
    public List<Integer> delRows(String[] delList) {
        List<Integer> res = new ArrayList<>();
        for(String id : delList) {
            evaluateDao.delEvaluate(Integer.parseInt(id));
            res.add(Integer.parseInt(id));
        }
        return res;
    }
}
