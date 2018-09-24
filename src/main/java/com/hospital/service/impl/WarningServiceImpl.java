package com.hospital.service.impl;

import com.hospital.dao.WarningDao;
import com.hospital.entity.Warning;
import com.hospital.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WarningServiceImpl implements WarningService {

    @Autowired
    private WarningDao warningDao;

    @Override
    public List<Warning> getWarning(int accountId, int page, int total) {
        int p = (page - 1) * total;
        return warningDao.getWarning(accountId, p, total);
    }

    @Override
    public int getTotal(int accountId) {
        return warningDao.getWaringTotal(accountId);
    }

    @Override
    public void updateRows(List<String[]> args) {
        for (String[] strings : args) {
            updateRow(Integer.parseInt(strings[0]), strings[1], Float.parseFloat(strings[2]), Float.parseFloat(strings[3]));
        }
    }

    public void updateRow(int warningId, String keyName, float minVal, float maxVal) {
        warningDao.updateWarningRow(warningId, keyName, minVal, maxVal);
    }

    @Override
    public List<Integer> delRows(String[] args) {

        List<Integer> ids = new ArrayList<>();
        for (String s : args) {
            warningDao.delWarningRow(Integer.parseInt(s));
            ids.add(Integer.parseInt(s));
        }
        return ids;
    }

    @Override
    public Map<Integer, String> addRow(String[] info, int accountId) {

        Map<Integer, String> errors = new HashMap<>();
        String keyName = info[0];
        if (info[1].equals("")) {
            errors.put(1, "最小值不能为空");
        } else if (info[2].equals("")) {
            errors.put(2, "最大值不能为空");
        } else {
            float minVal = Float.parseFloat(info[1]);
            float maxVal = Float.parseFloat(info[2]);

            if (minVal > maxVal) {
                errors.put(2, "最大值不能小于最小值");
            } else {
                warningDao.addWarningRow(keyName, minVal, maxVal, accountId);
            }
        }
        return errors;
    }
}
