package com.example.OrderService.service;

import java.util.List;

import com.example.OrderService.Request.OrderRequestDTO;
import com.example.OrderService.model.Order;

public interface OrderService {
	List<Order> getOrders();
	
	Order getOrderByOrderId(String orderId);
	
	Order saveOrder(OrderRequestDTO request);
}
