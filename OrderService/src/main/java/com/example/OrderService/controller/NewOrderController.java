package com.example.OrderService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderService.Request.OrderRequestDTO;
import com.example.OrderService.Request.UserRequestDTO;
import com.example.OrderService.contants.ApplicationConstants;
import com.example.OrderService.contants.RequestMappingConstants;
import com.example.OrderService.model.Order;
import com.example.OrderService.model.Product;
import com.example.OrderService.model.User;
import com.example.OrderService.service.OrderService;

@RestController
@RequestMapping(value = RequestMappingConstants.ORDER)
public class NewOrderController {

	private static final Logger LOGGER = LogManager.getLogger(NewOrderController.class);

	@Autowired
	OrderService orderService;

	/*
	 * author: paresh panchal date: 10/02/24 decription : to get orders details from
	 * db request : response : List<Order>
	 * 
	 */
	@GetMapping(value = RequestMappingConstants.GET_ORDERS)
	public List<Order> getOrders() {
		LOGGER.info("inside getOrders - Controller");
		return orderService.getOrders();
	}

	/*
	 * author: paresh panchal date: 10/02/24 decription : to Save/Update Order[1
	 * user at a time] details from db request : OrderRequestDTO request response :
	 * Map<String,String>
	 * 
	 */
	@PostMapping(value = RequestMappingConstants.SAVE_ORDER)
	public Map<String, String> saveOrder(@RequestBody OrderRequestDTO request) {
		LOGGER.info("inside saveOrder - Controller");
		Order order = orderService.saveOrder(request);
		Map<String, String> map = new HashMap<>();
		if (order != null) {
			map.put(ApplicationConstants.ORDER_ID, order.getOrderId());
			map.put(ApplicationConstants.RESPONSE, ApplicationConstants.SUCCESS_STATUS_MSG);
		} else {
			map.put(ApplicationConstants.ORDER_ID, ApplicationConstants.FAILURE_STATUS_CODE);
			map.put(ApplicationConstants.RESPONSE, ApplicationConstants.FAILURE_STATUS_MSG);
		}
		return map;
	}
}
