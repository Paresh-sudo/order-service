package com.example.OrderService.service;

import java.util.List;

import com.example.OrderService.model.Product;

public interface ProductService {
	List<Product> getProducts();
	
	Product addProduct(Product product);
}
