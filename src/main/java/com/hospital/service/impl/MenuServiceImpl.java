package com.hospital.service.impl;

import com.hospital.dao.MenuDao;
import com.hospital.entity.MainMenu;
import com.hospital.entity.Menu;
import com.hospital.service.MenuService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.applet.Main;

import java.util.*;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<MainMenu> getMenu(int type) {
        List<Menu> menu =  menuDao.getMenu(type);
        TreeMap list = new TreeMap();

        for (Menu aMenu : menu) {

            MainMenu m = (MainMenu) list.get(aMenu.getMainId());
            if (m == null) {
                m = new MainMenu(aMenu.getMainName(), aMenu.getIcon());
            }
            m.addMenu(aMenu);
            list.put(aMenu.getMainId(), m);
        }

        List<MainMenu> res = new ArrayList<>();

        for (Object key : list.keySet()) {
            res.add((MainMenu) list.get(key));
        }
        return res;
    }
}
