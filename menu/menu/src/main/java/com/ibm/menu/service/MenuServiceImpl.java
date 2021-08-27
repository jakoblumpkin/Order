package com.ibm.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.menu.model.Menu;
import com.ibm.menu.model.MenuInput;
import com.ibm.menu.repo.MenuRepo;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuRepo menurepo;
	
	public List<Menu> getMenuItems() {
		List<Menu> menuList = null;
		menuList = this.menurepo.findAll();
		return menuList;
	}
	
	public Menu getMenuItem(String menuItemNumber) {
		Menu menuItem = null;
		menuItem = this.menurepo.findByMenuItemNumber(menuItemNumber);
		return menuItem;
	}
	
	public Menu addMenu(MenuInput menu) {
		Menu addMenu = new Menu(menu.getMenuItemNumber(), menu.getCategory(), menu.getName(), menu.getDescription(), menu.getNumAvailable(), menu.getPrice());
		this.menurepo.insert(addMenu);
		return addMenu;
	}
}
