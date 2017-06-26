package com.viti.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viti.dao.UserDAO;
import com.viti.dto.AddressTO;
import com.viti.dto.UserTO;
import com.viti.model.Address;
import com.viti.model.User;
import com.viti.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createUser(User user) {

		// User model Object to Txn. Object.

		UserTO userTO = new UserTO();

		userTO.setFirstName(user.getFirstName());
		userTO.setMiddleName(user.getMiddleName());
		userTO.setLastName(user.getLastName());
		userTO.setGender(user.getGender());
		userTO.setDob(user.getDob());
		userTO.setEmail(user.getEmail());
		userTO.setMobileNo(user.getMobileNo());
		userTO.setPassword(user.getPassword());
		
		// Insert and Update date as of now.
		userTO.setCreatedOn(Calendar.getInstance());
		userTO.setUpdatedOn(Calendar.getInstance());
		
		// Embedded Address...
		
		// Convert Address Model object to Txn object.
		List<AddressTO> addresses = new ArrayList<>();
		Address address = user.getAddress();
		if (address != null) {
			//TODO: We might have to loop through...
			AddressTO addressTO = new AddressTO();
			addressTO.setAddress1(address.getAddress1());
			addressTO.setAddress2(address.getAddress2());
			addressTO.setCity(address.getCity());
			addressTO.setState(address.getState());
			addressTO.setCountry(address.getCountry());
			addressTO.setZipCode(address.getZipCode());
			
			// Insert and Update date as of now.
			addressTO.setCreatedOn(Calendar.getInstance());
			addressTO.setUpdatedOn(Calendar.getInstance());
			
			// Add to the address list.
			addresses.add(addressTO);
		}
		
		// Set the address.
		userTO.setAddresses(addresses);

		userDAO.save(userTO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub

		Iterable<UserTO> source = userDAO.findAll();
		List<UserTO> userTOs = new ArrayList<>();
		source.forEach(userTOs::add);

		// convert DTO object to DAO model object
		// List<User> users =
		// usersTOs.stream().map(User::new).collect(Collectors.toList());

		List<User> users = new ArrayList<>();
		for (UserTO userTO : userTOs) {
			User user = new User();
			user.setFirstName(userTO.getFirstName());
			user.setMiddleName(userTO.getMiddleName());
			user.setLastName(userTO.getLastName());
			user.setGender(userTO.getGender());
			user.setDob(userTO.getDob());
			user.setEmail(userTO.getEmail());
			user.setMobileNo(userTO.getMobileNo());
			user.setPassword(userTO.getPassword());

			users.add(user);
		}

		return users;
	}

}
