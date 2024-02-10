package com.example.OrderService.Converter;

import java.util.Date;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.OrderService.Request.OrderRequestDTO;
import com.example.OrderService.model.Order;
import com.example.OrderService.utils.CommanUtils;

public class OrderConverter {
	
	private static final Logger LOGGER = LogManager.getLogger(OrderConverter.class);

	 public static Order convertRequestToOrderEntity(OrderRequestDTO orderRequestDTO, Order existingOrder) {
	        LOGGER.info("inside convertRequestToOrderEntity - OrderConverter");
	        Order orderData = null;
	        try {
	            orderData = new Order();
	            if (existingOrder != null && existingOrder.getId() != 0) {
	                orderData.setId(existingOrder.getId());
	                orderData.setOrderId(existingOrder.getOrderId().trim());

	            } else {
	                /* generating random unique id */
	            	orderData.setOrderId(UUID.randomUUID().toString());
		           
	            }
	            // Set other properties
	            orderData.setUserId(CommanUtils.isBlank(orderRequestDTO.getUserId()) ? null : orderRequestDTO.getUserId().trim());
	            orderData.setName(CommanUtils.isBlank(orderRequestDTO.getOrderName()) ? null : orderRequestDTO.getOrderName().trim());
	            orderData.setPrice(Double.parseDouble(orderRequestDTO.getPrice()));
	            orderData.setStatus(CommanUtils.isBlank(orderRequestDTO.getStatus()) ? null : orderRequestDTO.getStatus().trim());
	            orderData.setCategory(CommanUtils.isBlank(orderRequestDTO.getCategory()) ? null : orderRequestDTO.getCategory().trim());
	            orderData.setQuantity(Long.parseLong(orderRequestDTO.getQuantity()));
	            orderData.setCreatedBy(CommanUtils.isBlank(orderRequestDTO.getCreatedBy()) ? null : orderRequestDTO.getCreatedBy().trim());
	            orderData.setCreatedDate(new Date());
	            orderData.setProductId(CommanUtils.isBlank(orderRequestDTO.getProductId()) ? null : orderRequestDTO.getProductId().trim());
	            if (existingOrder != null && existingOrder.getId() != 0) {
	            	orderData.setCreatedBy(CommanUtils.isBlank(existingOrder.getCreatedBy()) ? null :existingOrder.getCreatedBy().trim());
	            	orderData.setCreatedDate(existingOrder.getCreatedDate());	
	            	orderData.setUpdatedBy(CommanUtils.isBlank(orderRequestDTO.getUpdatedBy()) ? null : orderRequestDTO.getUpdatedBy().trim());
	            	orderData.setUpdatedDate(new Date());
		            orderData.setProductId(CommanUtils.isBlank(existingOrder.getProductId()) ? null : existingOrder.getProductId().trim());
	            }
	        } catch (Exception e) {
	            LOGGER.info("Exception : {}", e.getMessage());
	        }
	        return orderData;
	    }
}
