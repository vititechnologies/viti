package com.viti.model;

public class Student extends User {

	private long studentId;
	private String courseId;
	private String rollNo;
	private String studentClass;

	public Student() {
		super();
	}

	public Student(String firstName, String middleName, String lastName, String gender, String dob, String email) {
		super(firstName, middleName, lastName, gender, dob, email);
		// TODO Auto-generated constructor stub
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long l) {
		this.studentId = l;
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

}
