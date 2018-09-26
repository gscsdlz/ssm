package com.hospital.service;

import com.hospital.entity.MainMenu;

import java.util.List;

public interface MenuService {

    int ELDER_MENU = 1;

    List<MainMenu> getMenu(int type, String mainMenu, String subMenu);
}
