package com.viti.service.impl;


import java.util.ArrayList; 
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viti.dao.StaffDAO;
import com.viti.dto.AddressTO;
import com.viti.dto.StaffTO;
import com.viti.dto.UserTO;
import com.viti.model.Address;
import com.viti.model.Staff;
import com.viti.model.User;
import com.viti.service.StaffService;


@Service("staffService")
public class StaffServiceImpl implements StaffService{

	@Autowired
	StaffDAO staffDAO;
	
	@Override
	public void createStaff(Staff staff) {

		// User model Object to Txn. Object.

		StaffTO staffTO = new StaffTO();

		staffTO.setFirstName(staff.getFirstName());
		staffTO.setMiddleName(staff.getMiddleName());
		staffTO.setLastName(staff.getLastName());
		staffTO.setGender(staff.getGender());
		staffTO.setDob(staff.getDob());
		staffTO.setEmail(staff.getEmail());
		staffTO.setMobileNo(staff.getMobileNo());
		staffTO.setPassword(staff.getPassword());
		
		// Insert and Update date as of now.
		staffTO.setCreatedOn(Calendar.getInstance());
		staffTO.setUpdatedOn(Calendar.getInstance());
		
		// Embedded Address...
		
		// Convert Address Model object to Txn object.
		List<AddressTO> addresses = new ArrayList<>();
		Address address = staff.getAddress();
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
		staffTO.setAddresses(addresses);

		staffDAO.save(staffTO);
	}
	
	@Override
	public List<Staff> getStaff() {
		// TODO Auto-generated method stub

		Iterable<StaffTO> source = staffDAO.findAll();
		List<StaffTO> staffTOs = new ArrayList<>();
		
		source.forEach(staffTOs::add);

		// convert DTO object to DAO model object
		// List<User> users =
		// usersTOs.stream().map(User::new).collect(Collectors.toList());

		List<Staff> staffs = new ArrayList<>();
		for (StaffTO staffTO : staffTOs) {
			Staff staff = new Staff();
			staff.setFirstName(staffTO.getFirstName());
			staff.setMiddleName(staffTO.getMiddleName());
			staff.setLastName(staffTO.getLastName());
			staff.setGender(staffTO.getGender());
			staff.setDob(staffTO.getDob());
			staff.setEmail(staffTO.getEmail());
			staff.setMobileNo(staffTO.getMobileNo());
			staff.setPassword(staffTO.getPassword());

			staffs.add(staff);
		}

		return staffs;
	}

}

