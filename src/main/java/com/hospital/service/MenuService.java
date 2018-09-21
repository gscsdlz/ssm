package com.hospital.service;

import com.hospital.entity.MainMenu;

import java.util.List;

public interface MenuService {
    List<MainMenu> getMenu(int type);
}
