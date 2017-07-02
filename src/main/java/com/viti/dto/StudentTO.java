package com.viti.dto;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.viti.controller.UserController;

@Entity
@Table(name = "students")
public class StudentTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private long studentId;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "middlename")
	private String middleName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "password")
	private String password;
	@Column(name = "gender")
	private String gender;
	@Column(name = "dob")
	private String dob;
	@Column(name = "email")
	private String email;
	@Column(name = "mobileno")
	private String mobileNo;
	@Column(name = "cousre_id")
	private String courseId;
	@Column(name = "rollno")
	private String rollNo;
	@Column(name = "studentclass")
	private String studentClass;
	
	@ElementCollection
	@JoinTable(name = "address", joinColumns = @JoinColumn(name = "student_id"))
	@GenericGenerator(name = "increment-generator", strategy = "increment")
	@CollectionId(columns = {
			@Column(name = "address_id") }, generator = "increment-generator", type = @Type(type = "long"))
	private List<AddressTO> addresses;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	private Calendar createdOn;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on")
	private Calendar updatedOn;

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	public StudentTO() {
		super();
	}

	public StudentTO(long studentId, String firstName, String middleName, String lastName, String password,
			String gender, String dob, String email, String mobileNo, String courseId, String rollNo,
			String studentClass, List<AddressTO> addresses, Calendar createdOn, Calendar updatedOn) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.mobileNo = mobileNo;
		this.courseId = courseId;
		this.rollNo = rollNo;
		this.studentClass = studentClass;
		this.addresses = addresses;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public long getStudentId() {
		return studentId;
	}
	public void setStudentID(long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public List<AddressTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressTO> addresses) {
		this.addresses = addresses;
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

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		LOG.debug("Created date: " + createdOn);
		this.createdOn = createdOn;
	}

	public Calendar getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Calendar updatedOn) {
		LOG.debug("Updated date: " + updatedOn);
		this.updatedOn = updatedOn;
	}
	

}
