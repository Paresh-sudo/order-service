package com.example.OrderService.service;

import java.util.List;

import com.example.OrderService.Request.UserRequestDTO;
import com.example.OrderService.model.User;

public interface UserService {

	List<User> getUsers();
	
	User getUserByUserId(String userId);
	
	User saveUser(UserRequestDTO request);
	
	boolean isUserExist(String userId);
}
