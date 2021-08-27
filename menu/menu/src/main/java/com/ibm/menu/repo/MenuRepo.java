package com.ibm.menu.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.menu.model.Menu;


@Repository
public interface MenuRepo extends MongoRepository<Menu, Long> 
{
	public Menu findByMenuItemNumber(String menuItemNumber);
}
