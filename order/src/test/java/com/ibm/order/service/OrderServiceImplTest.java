package com.ibm.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ibm.order.endpoint.MenuEndpoint;
import com.ibm.order.model.Order;
import com.ibm.order.model.OrderInput;
import com.ibm.order.model.OrderInputMenuItem;
import com.ibm.order.model.OrderMenuItem;
import com.ibm.order.repo.OrderRepo;

class OrderServiceImplTest {
	
	@Mock
	private OrderRepo orderRepo;
	
	@InjectMocks
	private OrderServiceImpl orderService;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
    @SuppressWarnings("null")
	@DisplayName("Test if you get the order")
	@Test
	void testGetaOrder() {
        
    	//Given
    	String orderNumber = "ORDER-123";
    	List<OrderMenuItem> menuList = new ArrayList<OrderMenuItem>();
    	OrderMenuItem orderMenu = new OrderMenuItem("MENU129", 2, "Tbone", 35.0);
    	menuList.add(orderMenu);
    
    	Order testOrder = new Order("ORDER-101", "CUST456", menuList, 70.0);
    	when(orderRepo.findByOrderNumber(orderNumber)).thenReturn(testOrder);
    	
    	// When
    	Order orderResult = orderService.getOrder(orderNumber);
    	
    	
    	//Then
    	assertNotNull(orderResult);
    	assertEquals(orderResult, testOrder);
    	
    	
    	verify(orderRepo).findByOrderNumber(orderNumber);
	}

}
