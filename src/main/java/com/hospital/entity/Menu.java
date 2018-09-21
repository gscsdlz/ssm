package com.hospital.entity;

public class Menu {
    private int mainId;
    private int menuId;
    private String name;
    private String mainName;
    private String uri;
    private String icon;
    private int type;


    public void setMainId(int mainId) {
        this.mainId = mainId;
    }

    public int getMainId() {
        return mainId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMenuId() {
        return menuId;
    }

    public String getName() {
        return name;
    }

    public String getMainName() {
        return mainName;
    }

    public String getUri() {
        return uri;
    }

    public String getIcon() {
        return icon;
    }

    public int getType() {
        return type;
    }

    public String toString() {
        return menuId + ":" + name + ":" + mainName + ":" + uri + ":" + icon + ":" + type;
    }
}
