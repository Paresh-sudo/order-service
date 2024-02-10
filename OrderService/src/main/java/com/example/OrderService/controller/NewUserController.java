package com.example.OrderService.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderService.contants.RequestMappingConstants;
import com.example.OrderService.model.User;
import com.example.OrderService.service.UserService;

/*
 * paresh panchal
 * */

@RestController
@RequestMapping(value = RequestMappingConstants.ORDER)
public class NewUserController {

    private static final Logger LOGGER = LogManager.getLogger(NewUserController.class);

    @Autowired
    UserService userService;
    
	/*
	 *  author: paresh panchal
	 * date: 10/02/24
	 * decription : to get User details from db 
	 * request :
	 * response : List<User>
	 * 
	 * */
    @GetMapping(value = RequestMappingConstants.GET_USERS)
    public List<User> getUsers() {
    	LOGGER.info("inside getUsers - Controller");
    	return userService.getUsers();
    }
    
    
}
