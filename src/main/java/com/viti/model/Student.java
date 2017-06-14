package com.viti.model;

public class Student extends User {

	private String studentId;
	private String courseId;
	private String rollNo;
	private String studentClass;
	private String test;
	
	public Student(String firstName, String middleName, String lastName, String gender, String dob, String email) {
		super(firstName, middleName, lastName, gender, dob, email);
		// TODO Auto-generated constructor stub
	}

}
