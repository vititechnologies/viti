package com.viti.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viti.model.User;
import com.viti.service.UserService;

@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	private List<User> users = new ArrayList<>(
			Arrays.asList(new User("Sunildatta", "P", "Kulkarni", "Male", "10/10/2000", "sunil@viti.com")));

	@RequestMapping(value = "/users")
	public List<User> getUsers() {
		LOGGER.debug("User retrieved successfully");
		return users;
	}

	@RequestMapping(value = "/users/{id}")
	public User getUser(@PathVariable String id) {
		return users.stream().filter(t -> t.getFirstName().equals(id)).findFirst().get();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public void addUser(@RequestBody User user) {
		users.add(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable String id) {

		for (int i = 0; i < users.size(); i++) {
			User u1 = users.get(i);
			if (u1.getFirstName().equals(id)) {
				users.set(i, user);
			}
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public void deleteUser(@PathVariable String id) {
		users.removeIf(t -> t.getFirstName().equals(id));

	}

}
