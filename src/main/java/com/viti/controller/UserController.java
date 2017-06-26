package com.viti.controller;

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
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users")
	public List<User> getUsers() {
		LOG.debug("Entering to get users.");
		List<User> users = userService.getUsers();
		LOG.debug("User retrieved successfully");
		return users;
	}

	@RequestMapping(value = "/users/{id}")
	public User getUser(@PathVariable String id) {
		// Call service method to get one user
		return null;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public void addUser(@RequestBody User user) {
		LOG.info("Entering creating to user");
		userService.createUser(user);
		LOG.info("Successfully created user");
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable String id) {
		// Call service method to update user.
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public void deleteUser(@PathVariable String id) {
		// Call service method to delete users.

	}

}
