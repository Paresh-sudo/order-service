package com.example.OrderService.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderService.model.Order;
import com.example.OrderService.serviceImpl.OrderService;
@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	
	@GetMapping("/orders")
	public ResponseEntity getAllOrders(@RequestParam(defaultValue = "0") int page,
	                                @RequestParam(defaultValue = "5") int size,
	                                @RequestParam(defaultValue = "id,asc") String sort) {
		logger.info("inside getAllOrders - Controller");
		Sort sorting = Sort.by(sort.split(",")[0]);
        if (sort.endsWith(",desc")) {
            sorting = sorting.descending();
        }
        Pageable pageable = PageRequest.of(page, size,sorting);
		
//		logger.debug("inside orders - Controller");
		return new ResponseEntity<>(orderService.getAllOrders(pageable).getContent(),HttpStatus.OK);
	
	}

	@GetMapping("/orderswithoutlimit")
	public ResponseEntity getAllOrders1() {
		logger.info("inside getAllOrders - Controller");
//		logger.debug("inside orders - Controller");
		return new ResponseEntity<>(orderService.getAllOrders(),HttpStatus.OK);
	}
	
	/* we can add this search with above page and sort as per our need
	 * need to use above Pageable in this getOrderByName
	 * same we can do search and sort for all different attributes.
	 * or if we don't want to use separate method 
	 * then we can generalize one method and create new
	 * method in orderRepository to do filtering on multiple attribuets */
	@GetMapping("/orders/search")
	public ResponseEntity getOrderByName(@RequestParam(defaultValue = "") String name) {
		logger.info("inside getOrderByName - Controller");
//		logger.debug("inside orders - Controller");
		return new ResponseEntity<>(orderService.getOrderByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity getOrderById(@PathVariable int id){
		logger.info("inside getOrderById - Controller");
//		logger.debug("inside orders - Controller");
		Optional<Order> order = orderService.getOrderById(id);
		if(order.isPresent()) {
			return new ResponseEntity<>(order,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(order,HttpStatus.NOT_FOUND);

		}
	}
}
