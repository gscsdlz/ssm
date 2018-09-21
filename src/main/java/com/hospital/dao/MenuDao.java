package com.hospital.dao;

import com.hospital.entity.Menu;

import java.util.List;

public interface MenuDao {
    List<Menu> getMenu(int type);
}
