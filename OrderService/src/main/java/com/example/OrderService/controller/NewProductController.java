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

import com.example.OrderService.Request.ProductRequestDTO;
import com.example.OrderService.contants.ApplicationConstants;
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
    
    /*
	 * author: paresh panchal
	 * date: 10/02/24
	 * decription : to Save/Update product[1 product at a time] details from db
	 * request : ProductRequestDTO request
	 * response : Map<String,String>
	 * 
	 * */
    @PostMapping(value = RequestMappingConstants.SAVE_PRODUCT)
    public Map<String,String> saveProduct(@RequestBody ProductRequestDTO request){
    	LOGGER.info("inside saveProduct - Controller");
    	Product product = productService.saveProduct(request);
    	Map<String,String> map = new HashMap<>();
    	if(product!=null) {
    		map.put(ApplicationConstants.PRODUCT_ID, product.getProductId());
    		map.put(ApplicationConstants.RESPONSE, ApplicationConstants.SUCCESS_STATUS_MSG);
    	}else {
    		map.put(ApplicationConstants.PRODUCT_ID, ApplicationConstants.FAILURE_STATUS_CODE);
    		map.put(ApplicationConstants.RESPONSE, ApplicationConstants.FAILURE_STATUS_MSG);
    	}
    	return map;
    }

}
