package com.example.OrderService.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrderService.model.Order;
import com.example.OrderService.repository.OrderRepository;
import com.example.OrderService.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger LOGGER = LogManager.getLogger(OrderServiceImpl.class);

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public List<Order> getOrders() {
		LOGGER.info("inside getUsers - UserServiceImpl ");
		return orderRepository.findAll();
	}

	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
