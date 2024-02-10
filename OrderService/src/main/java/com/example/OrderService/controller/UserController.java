package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserRepository UserRepository; 
	
	@GetMapping("/users")
	public ResponseEntity getAllUsers(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id,asc") String sort) {
		logger.info("inside getAllUsers - Controller");
		Sort sorting = Sort.by(sort.split(",")[0]);
        if (sort.endsWith(",desc")) {
            sorting = sorting.descending();
        }
        Pageable pageable = PageRequest.of(page, size,sorting);
		
        List<User> Users = UserRepository.findAll(pageable).getContent();
        
		return new ResponseEntity<>(Users,HttpStatus.OK);
	
	}
}
