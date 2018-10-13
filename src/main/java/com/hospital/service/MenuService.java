package com.hospital.service;

import com.hospital.entity.MainMenu;

import java.util.List;

public interface MenuService {

    int ELDER_MENU = 1;
    int DOCTOR_MENU = 2;
    int FAMILY_MENU = 3;
    int GROUP_MENU = 4;
    int SYSTEM_MENU = 5;

    List<MainMenu> getMenu(int type, String mainMenu, String subMenu);
}
