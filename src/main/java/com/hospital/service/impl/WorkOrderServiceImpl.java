package com.hospital.service.impl;

import com.hospital.dao.WorkOrderDao;
import com.hospital.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {
    @Autowired
    private WorkOrderDao  workOrderDao;


}
