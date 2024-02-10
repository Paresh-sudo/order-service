package com.example.OrderService.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderService.contants.RequestMappingConstants;
import com.example.OrderService.model.Product;
import com.example.OrderService.model.User;
import com.example.OrderService.service.ProductService;

@RestController
@RequestMapping(value = RequestMappingConstants.ORDER)
public class NewProductController {

	private static final Logger LOGGER = LogManager.getLogger(NewProductController.class);
	
	@Autowired
	ProductService productService;
	
	/*
	 *  author: paresh panchal
	 * date: 10/02/24
	 * decription : to get products details from db 
	 * request :
	 * response : List<Product>
	 * 
	 * */
    @GetMapping(value = RequestMappingConstants.GET_PRODUCTS)
    public List<Product> getProducts() {
    	LOGGER.info("inside getProducts - Controller");
    	return productService.getProducts();
    }
    
	

}
