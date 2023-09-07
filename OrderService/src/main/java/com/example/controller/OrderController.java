package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Order;
import com.example.service.OrderService;
@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
    
	private static List<Order> orders = new ArrayList<>(Arrays.asList(
			new Order(1,"TV",10000),
			new Order(2,"Mobile",5000),
			new Order(3,"Mobile",8000)
			));
	
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		logger.info("inside orders - Controller");
		logger.debug("inside orders - Controller");
		return orderService.getAllOrders();
	}
}
