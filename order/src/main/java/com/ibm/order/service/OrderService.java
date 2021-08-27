package com.ibm.order.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.order.model.Order;
import com.ibm.order.model.OrderInput;

@Component
public interface OrderService {
	
	public Order getOrder(String orderNumber);
	public List<Order> getOrders();
	public Order addOrder(OrderInput orderInput);
}
