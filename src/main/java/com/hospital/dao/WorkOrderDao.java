package com.hospital.dao;

import com.hospital.entity.WorkOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkOrderDao {
    List<WorkOrder> getAllWorkOrder();

    int addWorkOrder(@Param("elder_id") int elderId,
                     @Param("account_id") int accountId,
                     @Param("type") int type,
                     @Param("content") String content,
                     @Param("price") float price,
                     @Param("service_time") String serviceTime);

    int deleteWorkOrder(@Param("order_id") int orderId);

    int updateWorkOrder(@Param("order_id") int orderId,
                        @Param("elder_id") int elderId,
                        @Param("type") int type,
                        @Param("content") String content,
                        @Param("price") float price,
                        @Param("service_time") String serviceTime);
}
