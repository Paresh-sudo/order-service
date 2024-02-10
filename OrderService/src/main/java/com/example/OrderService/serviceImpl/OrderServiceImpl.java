package com.example.OrderService.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrderService.Converter.OrderConverter;
import com.example.OrderService.Converter.ProductConverter;
import com.example.OrderService.Request.OrderRequestDTO;
import com.example.OrderService.model.Order;
import com.example.OrderService.model.Product;
import com.example.OrderService.repository.OrderRepository;
import com.example.OrderService.service.OrderService;
import com.example.OrderService.service.UserService;

@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger LOGGER = LogManager.getLogger(OrderServiceImpl.class);

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	UserService userService;
	
	@Override
	public List<Order> getOrders() {
		LOGGER.info("inside getUsers - OrderServiceImpl ");
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderByOrderId(String orderId) {
		LOGGER.info("inside getOrderByOrderId - OrderServiceImpl ");
		return orderRepository.getOrderByOrderId(orderId);
	}

	/* First Checking whether orderId is exist or not
	 * if yes updating record else saving record. */
	@Override
	public Order saveOrder(OrderRequestDTO request) {
		LOGGER.info("inside saveOrder - OrderServiceImpl ");
		if(!userService.isUserExist(request.getUserId())) {
//			need to add exception
			return null;
		}
		Order existingOrder = getOrderByOrderId(request.getOrderId());
		Order order = OrderConverter.convertRequestToOrderEntity(request, existingOrder);
		order = saveOrder(order);
		return order;
	}

	private Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

}
