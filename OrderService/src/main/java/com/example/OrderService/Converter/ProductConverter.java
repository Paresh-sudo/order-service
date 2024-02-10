package com.example.OrderService.Converter;

import java.util.Date;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.OrderService.Request.ProductRequestDTO;
import com.example.OrderService.model.Product;
import com.example.OrderService.utils.CommanUtils;

public class ProductConverter {

	private static final Logger LOGGER = LogManager.getLogger(ProductConverter.class);

	public static Product convertRequestToProductEntity(ProductRequestDTO productRequestDTO, Product existingProduct) {
        LOGGER.info("inside convertRequestToProductEntity - ProductConverter");
        Product productData = null;
        try {
            productData = new Product();
            if (existingProduct != null && existingProduct.getId() != 0) {
                productData.setId(existingProduct.getId());
                productData.setProductId(existingProduct.getProductId().trim());
                
            } else {
                /* generating random unique id */
            	productData.setProductId(UUID.randomUUID().toString());
            }
            // Set other properties
            productData.setUserId(CommanUtils.isBlank(productRequestDTO.getUserId()) ? null : productRequestDTO.getUserId().trim());
            productData.setName(CommanUtils.isBlank(productRequestDTO.getName()) ? null : productRequestDTO.getName().trim());
            productData.setDescription(CommanUtils.isBlank(productRequestDTO.getDescription()) ? null : productRequestDTO.getDescription().trim());
            productData.setPrice(Double.parseDouble(productRequestDTO.getPrice()));
            productData.setCategory(CommanUtils.isBlank(productRequestDTO.getCategory()) ? null : productRequestDTO.getCategory().trim());
            productData.setQuantity(Long.parseLong(productRequestDTO.getQuantity()));
            productData.setCreatedBy(CommanUtils.isBlank(productRequestDTO.getCreatedBy()) ? null : productRequestDTO.getCreatedBy().trim());
            productData.setCreatedDate(new Date());
            if (existingProduct != null && existingProduct.getId() != 0) {
            	productData.setCreatedBy(CommanUtils.isBlank(existingProduct.getCreatedBy()) ? null :existingProduct.getCreatedBy().trim());
            	productData.setCreatedDate(existingProduct.getCreatedDate());
            	productData.setUpdatedBy(CommanUtils.isBlank(productRequestDTO.getUpdatedBy()) ? null : productRequestDTO.getUpdatedBy().trim());
            	productData.setUpdatedDate(new Date());
            }
        } catch (Exception e) {
            LOGGER.info("Exception : {}", e.getMessage());
        }
        return productData;
    }
}
