package com.example.OrderService.service;

import java.util.List;

import com.example.OrderService.Request.ProductRequestDTO;
import com.example.OrderService.model.Product;

public interface ProductService {
	
	List<Product> getProducts();
	
	Product getProductByProductId(String productId);
	
	Product saveProduct(ProductRequestDTO request);
}
