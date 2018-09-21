package com.hospital.service.impl;

import com.hospital.dao.MenuDao;
import com.hospital.entity.Menu;
import com.hospital.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> getMenu(int type) {
        return menuDao.getMenu(type);
    }
}
