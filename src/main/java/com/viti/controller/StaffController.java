package com.viti.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viti.model.Staff;

@RestController
public class StaffController {
private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/staff")
	public List<Staff> getStaff() {
		
		List<Staff> staff = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		cal.set(1976, 4, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Staff s = new Staff("Dr.Vikas", "M", "Sharma", "Male", sdf.format(cal.getTime()), "vikas.sharma@viti.com");
		staff.add(s);
		LOGGER.debug("Staff added successfully");
		return staff;
	}

}
