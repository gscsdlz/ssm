package com.hospital.service.impl;

import com.hospital.dao.WorkOrderDao;
import com.hospital.entity.WorkOrder;
import com.hospital.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {
    @Autowired
    private WorkOrderDao  workOrderDao;


    @Override
    public List<WorkOrder> getAll() {
        return workOrderDao.getAllWorkOrder();
    }

    @Override
    public List<Integer> delRows(String[] delList) {
        List<Integer> res = new ArrayList<>();
        for (String ids : delList) {
            workOrderDao.deleteWorkOrder(Integer.parseInt(ids));
            res.add(Integer.parseInt(ids));
        }
        return res;
    }

    @Override
    public int updateRows(List<String[]> updateStringList) {
        int sum = 0;
        for(String[] args : updateStringList) {
            sum += workOrderDao.updateWorkOrder(
                    Integer.parseInt(args[0]),
                    Integer.parseInt(args[1]),
                    Integer.parseInt(args[2]),
                    args[3],
                    Float.parseFloat(args[4]),
                    args[5]);
        }
        return sum;
    }

    @Override
    public Map<Integer, String> addWorkOrder(int accountId, String[] info) {
        Map<Integer, String> errors = new HashMap<>();
        if (info[2].length() == 0) {
            errors.put(2, "内容不能为空");
        }
        if (info[3].length() == 0) {
            errors.put(3, "价格不能为空");
        }
        if(info[4].length() == 0) {
            errors.put(4, "服务时间不为空");
        }
        if (errors.size() == 0) {
            workOrderDao.addWorkOrder(
                    Integer.parseInt(info[0]),
                    accountId,
                    Integer.parseInt(info[1]),
                    info[2],
                    Float.parseFloat(info[3]),
                    info[4]
            );
        }
        return errors;
    }
}
