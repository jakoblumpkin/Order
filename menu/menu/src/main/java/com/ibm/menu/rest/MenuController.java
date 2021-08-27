package com.ibm.menu.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.menu.model.Menu;
import com.ibm.menu.model.MenuInput;
import com.ibm.menu.service.MenuService;

@RestController
@RequestMapping(value= "/menu")
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	private final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@RequestMapping(value="/menuitems", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMenu() {
		logger.info("Entered get Menus");
		List<Menu> listMenus = this.menuService.getMenuItems();
		ResponseEntity<List<Menu>> responseEntity = new ResponseEntity<List<Menu>>(listMenus, HttpStatus.OK);
		logger.debug("Exited get Menus");
		return responseEntity;
	}
	
	@RequestMapping(value="/menu/{menuItemNumber}", method = RequestMethod.GET)
	public ResponseEntity<?> getMenuItem(@PathVariable(value="menuItemNumber") String menuItemNumber) {
		Menu menuItem = this.menuService.getMenuItem(menuItemNumber);
		ResponseEntity<Menu> responseEntity = new ResponseEntity<Menu>(menuItem, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value="/menu", method = RequestMethod.POST)
	public ResponseEntity<?> addMenu(@RequestBody MenuInput menu) {
		Menu addedmenu = this.menuService.addMenu(menu);
		ResponseEntity<Menu> responseEntity = new ResponseEntity<Menu>(addedmenu, HttpStatus.OK);
		return responseEntity;
	}
}
