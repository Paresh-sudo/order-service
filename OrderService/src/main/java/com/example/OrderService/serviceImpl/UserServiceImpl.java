package com.example.OrderService.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrderService.Converter.OrderConverter;
import com.example.OrderService.Converter.UserConverter;
import com.example.OrderService.Request.UserRequestDTO;
import com.example.OrderService.model.Order;
import com.example.OrderService.model.User;
import com.example.OrderService.repository.UserRepository;
import com.example.OrderService.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
		LOGGER.info("inside getUsers - UserServiceImpl ");
		return userRepository.findAll();
	}

	@Override
	public User getUserByUserId(String userId) {
		LOGGER.info("inside getUserByUserId - UserServiceImpl ");
		return userRepository.getUserByUserId(userId);
	}

	
	@Override
	public boolean isUserExist(String userId) {
		LOGGER.info("inside isUserExist - UserServiceImpl ");
		return userRepository.IsUserExistByUserId(userId)!=null ? true : false;
	}

	/* First Checking whether user is exist or not
	 * if yes updating record else saving record. */
	@Override
	public User saveUser(UserRequestDTO request) {
		LOGGER.info("inside saveUser - UserServiceImpl ");
		User existingUser = getUserByUserId(request.getUserId());
		User user = UserConverter.convertRequestToUserEntity(request, existingUser);
		user = saveUser(user);
		return user;
	}

	private User saveUser(User user) {
		return userRepository.save(user);
	}
	

}
