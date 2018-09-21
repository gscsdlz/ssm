package com.hospital.service;

import com.hospital.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenu(int type);
}
