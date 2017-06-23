package com.viti.service.impl;

import org.springframework.stereotype.Service;

import com.viti.dao.UserDAO;
import com.viti.model.User;
import com.viti.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	UserDAO userDAO;
	
	@Override
	public void createUser(User user) {
		userDAO.save(user);	
	}

}
