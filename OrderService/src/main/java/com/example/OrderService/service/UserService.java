package com.example.OrderService.service;

import java.util.List;

import com.example.OrderService.model.User;

public interface UserService {

	List<User> getUsers();
	
	User saveUser(User user);
}
