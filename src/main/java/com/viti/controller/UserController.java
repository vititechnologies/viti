package com.viti.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viti.model.User;

@RestController
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/users")
	public List<User> getUsers() {
		
		List<User> users = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		cal.set(1976, 4, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		User u = new User("Sunildatta", "P", "Kulkarni", "Male", sdf.format(cal.getTime()), "sunil@viti.com");
		users.add(u);
		LOGGER.debug("User added successfully");
		return users;
	}

}
