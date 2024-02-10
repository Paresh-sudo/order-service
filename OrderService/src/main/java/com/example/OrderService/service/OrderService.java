package com.example.OrderService.service;

import java.util.List;

import com.example.OrderService.model.Order;

public interface OrderService {
	List<Order> getOrders();
	
	Order addOrder(Order order);
}
