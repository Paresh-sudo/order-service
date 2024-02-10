package com.example.OrderService.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderService.contants.RequestMappingConstants;
import com.example.OrderService.model.Order;
import com.example.OrderService.model.Product;
import com.example.OrderService.service.OrderService;

@RestController
@RequestMapping(value = RequestMappingConstants.ORDER)
public class NewOrderController {
	
	private static final Logger LOGGER = LogManager.getLogger(NewOrderController.class);
	
	@Autowired
	OrderService orderService;
	
	/*
	 *  author: paresh panchal
	 * date: 10/02/24
	 * decription : to get orders details from db 
	 * request :
	 * response : List<Order>
	 * 
	 * */
    @GetMapping(value = RequestMappingConstants.GET_ORDERS)
    public List<Order> getOrders() {
    	LOGGER.info("inside getOrders - Controller");
    	return orderService.getOrders();
    }

}
