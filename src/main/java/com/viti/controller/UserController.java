package com.viti.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viti.model.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	//@RequestMapping(value = "/all")
	public List<User> getUsers() {
		
		List<User> users = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		cal.set(1976, 4, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		User u = new User("Sunildatta", "Kulkarni", "Male", sdf.format(cal.getTime()), "sunil@viti.com");
		users.add(u);
		return users;
	}

}
