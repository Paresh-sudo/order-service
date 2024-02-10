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
import com.example.OrderService.Request.UserRequestDTO;
import com.example.OrderService.contants.ApplicationConstants;
import com.example.OrderService.contants.RequestMappingConstants;
import com.example.OrderService.model.Product;
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
    
    /*
   	 * author: paresh panchal
   	 * date: 10/02/24
   	 * decription : to Save/Update user[1 user at a time] details from db
   	 * request : UserRequestDTO request
   	 * response : Map<String,String>
   	 * 
   	 * */
       @PostMapping(value = RequestMappingConstants.SAVE_USER)
       public Map<String,String> saveUser(@RequestBody UserRequestDTO request){
       	LOGGER.info("inside saveUser - Controller");
       	User user = userService.saveUser(request);
       	Map<String,String> map = new HashMap<>();
       	if(user!=null) {
       		map.put(ApplicationConstants.USER_ID, user.getUserId());
       		map.put(ApplicationConstants.RESPONSE, ApplicationConstants.SUCCESS_STATUS_MSG);
       	}else {
       		map.put(ApplicationConstants.USER_ID, ApplicationConstants.FAILURE_STATUS_CODE);
       		map.put(ApplicationConstants.RESPONSE, ApplicationConstants.FAILURE_STATUS_MSG);
       	}
       	return map;
       }
    
}
