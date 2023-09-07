package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Order;
import com.example.repository.OrderRepository;

@Service
public class OrderService {
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
    
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getAllOrders(){
		logger.info("inside orders - Service");
		return orderRepository.findAll();
	}
}	
