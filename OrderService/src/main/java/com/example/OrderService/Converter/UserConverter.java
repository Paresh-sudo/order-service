package com.example.OrderService.Converter;

import java.util.Date;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import com.example.OrderService.Request.UserRequestDTO;
import com.example.OrderService.model.User;
import com.example.OrderService.utils.CommanUtils;

public class UserConverter {
	
	private static final Logger LOGGER = LogManager.getLogger(UserConverter.class);
	
	/* commanutils contain isBlank method which check whether string is blank or null
	 * if it's blank then we'r setting null value else trimming the string and appending.
	 * java.util.Date give date and time 
	 * else java.sql.Date only store Date*/
	
	 public static User convertRequestToUserEntity(UserRequestDTO userRequestDTO, User existingUser) {
		 	LOGGER.info("inside convertRequestToUserEntity - UserConverter");
		 	User userData = null;
	        try {
				userData = new User();
				if (existingUser!=null && existingUser.getId() != 0) {
		        	userData.setId(existingUser.getId());
		        	userData.setUserId(existingUser.getUserId().trim());
		        }else {
					/* generating randonm unique id */
		        	userData.setUserId(UUID.randomUUID().toString());
		        }
		        // Set other properties
				userData.setFirstName(CommanUtils.isBlank(userRequestDTO.getFirstName()) ? null :userRequestDTO.getFirstName().trim());
				userData.setLastName(CommanUtils.isBlank(userRequestDTO.getLastName()) ? null :userRequestDTO.getLastName().trim());
				userData.setEmail(CommanUtils.isBlank(userRequestDTO.getEmail()) ? null :userRequestDTO.getEmail().trim());
				userData.setCreatedBy(CommanUtils.isBlank(userRequestDTO.getCreatedBy()) ? null :userRequestDTO.getCreatedBy().trim());
				userData.setCreatedDate(new Date());
		        if (existingUser!=null && existingUser.getId() != 0) {
		        	userData.setCreatedBy(CommanUtils.isBlank(existingUser.getCreatedBy()) ? null :existingUser.getCreatedBy().trim());
		        	userData.setCreatedDate(existingUser.getCreatedDate());
		        	userData.setUpdatedBy(CommanUtils.isBlank(userRequestDTO.getUpdatedBy()) ? null :userRequestDTO.getUpdatedBy().trim());
		        	userData.setUpdatedDate(new Date());
		        }
			} catch (Exception e) {
				LOGGER.info("Excetion : {}",e.getMessage());
			}
	        return userData;
	    }
	 
	 
}
