package com.hospital.service;

import com.hospital.entity.WorkOrder;

import java.util.List;

public interface WorkOrderService {
    List<WorkOrder> getAll();

    List<Integer> delRows(String[] delList);

    int updateRows(List<String[]> updateStringList);
}
