package com.viti.model;

public class Staff extends User {

	private String staffId;

	public Staff() {
		super();
	}

	public Staff(String firstName, String middleName, String lastName, String gender, String dob, String email) {
		super(firstName, middleName, lastName, gender, dob, email);
		// TODO Auto-generated constructor stub
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

}
