package com.viti.service;

import java.util.List;

import com.viti.model.User;

public interface UserService {

	/**
	 * Creates user.
	 * 
	 * @param user
	 *            the User Object.
	 */
	public void createUser(User user);

	/**
	 * Returns the list of Users.
	 * 
	 * @return the list of users.
	 */
	public List<User> getUsers();
}
