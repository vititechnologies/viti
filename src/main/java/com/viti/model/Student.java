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

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}
