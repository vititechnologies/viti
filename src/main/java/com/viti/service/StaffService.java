package com.viti.service;

import java.util.List;

import com.viti.model.Staff;

public interface StaffService {
	/**
	 * Creates staff.
	 * 
	 * @param staff
	 *            the User Object.
	 */
	public void createStaff(Staff staff);

	/**
	 * Returns the list of Staff.
	 * 
	 * @return the list of staff.
	 */
	public  List<Staff> getStaff();
	}

