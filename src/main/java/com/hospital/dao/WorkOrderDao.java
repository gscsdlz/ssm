package com.hospital.dao;

import com.hospital.entity.WorkOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkOrderDao {
    List<WorkOrder> getAllWorkOrder();

    List<WorkOrder> getAllWorkOrderByType(@Param("type") int type);

    int deleteWorkOrder(@Param("order_is") int orderId);
}
