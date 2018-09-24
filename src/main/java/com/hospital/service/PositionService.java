package com.hospital.service;

import com.hospital.entity.Position;

public interface PositionService {

    Position getPosition(int account_id, String date);
}
