package com.hospital.service.impl;

import com.hospital.dao.WorkOrderDao;
import com.hospital.entity.WorkOrder;
import com.hospital.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            //sum += workOrderDao.updateWorkOrder();
        }
        return sum;
    }
}
