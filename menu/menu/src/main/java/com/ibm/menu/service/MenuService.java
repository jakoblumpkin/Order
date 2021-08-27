package com.ibm.menu.service;

import java.util.List;

import com.ibm.menu.model.Menu;
import com.ibm.menu.model.MenuInput;

public interface MenuService {
    public List<Menu> getMenuItems();
    public Menu getMenuItem(String menuItemNumber);
    public Menu addMenu(MenuInput menu);
}
