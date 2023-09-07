package com.example.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Order;
import com.example.repository.OrderRepository;

@Service
public class OrderService {
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
    
	@Autowired
	private OrderRepository orderRepository;
	
	public Page<Order> getAllOrders(Pageable pageable) {
	    return orderRepository.findAll(pageable);
	}


	public Optional<Order> getOrderById(int id) {
		logger.info("inside getOrderById - Service");
		return orderRepository.findById(id);
	}


	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}


	public List<Order> getOrderByName(String name) {
		logger.info("inside getOrderByName - Service");
		return orderRepository.findOrderByName(name);
	}
}	
