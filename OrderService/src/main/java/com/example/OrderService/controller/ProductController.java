package com.example.OrderService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderService.model.Product;
import com.example.OrderService.model.User;
import com.example.OrderService.repository.ProductRepository;
import com.example.OrderService.serviceImpl.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService; 
	
	@Autowired
	private ProductRepository productRepository; 
	
	@GetMapping("/products")
	public ResponseEntity getAllProducts(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id,asc") String sort) {
		logger.info("inside getAllProducts - Controller");
		Sort sorting = Sort.by(sort.split(",")[0]);
        if (sort.endsWith(",desc")) {
            sorting = sorting.descending();
        }
        Pageable pageable = PageRequest.of(page, size,sorting);
		
        List<Product> products = productRepository.findAll(pageable).getContent();
        
//        User user = productRepository.findAll(pageable).getContent().get(0).getUser();
        
		return new ResponseEntity<>(products,HttpStatus.OK);
		
//		return new ResponseEntity<>(productRepository.findAll(pageable),HttpStatus.OK);
	
	}
}
