package com.hospital.dao;

import com.hospital.entity.Position;
import org.apache.ibatis.annotations.Param;

public interface PositionDao {
    Position getPosition(@Param("account_id") int account_id, @Param("date") String date);

    Position queryLastPosition(@Param("account_id") int accountId);
}
