package com.example.OrderService.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrderService.Converter.ProductConverter;
import com.example.OrderService.Request.ProductRequestDTO;
import com.example.OrderService.model.Product;
import com.example.OrderService.repository.ProductRepository;
import com.example.OrderService.service.ProductService;
import com.example.OrderService.service.UserService;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LogManager.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserService userService;
	
	@Override
	public List<Product> getProducts() {
		LOGGER.info("inside getProducts - ProductServiceImpl ");
		return productRepository.findAll();
	}

	@Override
	public Product getProductByProductId(String productId) {
		LOGGER.info("inside getProductByProductId - ProductServiceImpl ");
		return productRepository.getProductByProductId(productId);
	}

	/* First Checking whether productId is exist or not
	 * if yes updating record else saving record. */
	@Override
	public Product saveProduct(ProductRequestDTO request) {
		LOGGER.info("inside saveProduct - ProductServiceImpl ");
		if(!userService.isUserExist(request.getUserId())) {
//			need to add exception
			return null;
		}
		Product existingProduct = getProductByProductId(request.getProductId());
		Product product = ProductConverter.convertRequestToProductEntity(request, existingProduct);
		product = saveProduct(product);
		return product;
	}

	private Product saveProduct(Product product) {
		return productRepository.save(product);
	}


}
