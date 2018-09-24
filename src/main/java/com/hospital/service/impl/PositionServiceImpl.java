package com.hospital.service.impl;

import com.hospital.dao.PositionDao;
import com.hospital.entity.Position;
import com.hospital.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

    @Override
    public Position getPosition(int account_id, String date) {
        Position p = positionDao.getPosition(account_id, date);
        if (p != null)
            p.handleJSON();
        return p;
    }
}
