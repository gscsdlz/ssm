package com.hospital.entity;

import sun.applet.Main;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;


public class MainMenu {
    private String mainName;
    private String icon;
    private int type;
    private List<Menu> menus;
    private boolean active;

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return active;
    }

    public MainMenu() {
        menus = new ArrayList<>();
    }

    public MainMenu(String mainName, String icon, int type) {
        this.mainName = mainName;
        this.icon = icon;
        this.type = type;

        menus = new ArrayList<>();
    }

    public MainMenu(String mainName, String icon) {
        this.mainName = mainName;
        this.icon = icon;

        menus = new ArrayList<>();
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMainName() {
        return mainName;
    }

    public String getIcon() {
        return icon;
    }

    public void addMenu(Menu m) {
        menus.add(m);
    }

    public List<Menu> getMenu() {
        return menus;
    }

    @Override
    public String toString() {
        return mainName;
    }

    public void setSubMenuActive(String name) {
        for (Menu m : menus) {
            if (m.getName() == name) {
                m.setActive(true);
            }
        }
    }
}
