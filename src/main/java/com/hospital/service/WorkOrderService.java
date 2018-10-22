package com.hospital.service;

import com.hospital.entity.WorkOrder;

import java.util.List;
import java.util.Map;

public interface WorkOrderService {
    List<WorkOrder> getAll();

    List<Integer> delRows(String[] delList);

    int updateRows(List<String[]> updateStringList);

    Map<Integer, String> addWorkOrder(int accountId, String[] info);
}
