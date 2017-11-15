package com.viti.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viti.dao.StudentDAO;
import com.viti.dto.AddressTO;
import com.viti.dto.StudentTO;
import com.viti.model.Address;
import com.viti.model.Student;

import com.viti.service.StudentService;



@Service("StudentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDAO studentDAO;
	
	
	@Override
	public void createStudent(Student student) {

		// User model Object to Txn. Object.

		StudentTO studentTO = new StudentTO();

		studentTO.setFirstName(student.getFirstName());
		studentTO.setMiddleName(student.getMiddleName());
		studentTO.setLastName(student.getLastName());
		studentTO.setGender(student.getGender());
		studentTO.setDob(student.getDob());
		studentTO.setEmail(student.getEmail());
		studentTO.setMobileNo(student.getMobileNo());
		studentTO.setPassword(student.getPassword());
		studentTO.setCourseId(student.getCourseId());
		studentTO.setRollNo(student.getRollNo());
		studentTO.setStudentClass(student.getStudentClass());
		
		// Insert and Update date as of now.
		studentTO.setCreatedOn(Calendar.getInstance());
		studentTO.setUpdatedOn(Calendar.getInstance());
		
		// Embedded Address...
		
		// Convert Address Model object to Txn object.
		List<AddressTO> addresses = new ArrayList<>();
		Address address = student.getAddress();
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
		studentTO.setAddresses(addresses);

		studentDAO.save(studentTO);
	}
	
	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub

		Iterable<StudentTO> source = studentDAO.findAll();
		List<StudentTO> studentTOs = new ArrayList<>();
		source.forEach(studentTOs::add);
		
		List<Student> students = new ArrayList<>();
		for (StudentTO studentTO : studentTOs) {
			Student student = new Student();
			student.setStudentId(studentTO.getStudentId());
			student.setFirstName(studentTO.getFirstName());
			student.setMiddleName(studentTO.getMiddleName());
			student.setLastName(studentTO.getLastName());
			student.setGender(studentTO.getGender());
			student.setDob(studentTO.getDob());
			student.setEmail(studentTO.getEmail());
			student.setMobileNo(studentTO.getMobileNo());
			student.setPassword(studentTO.getPassword());
			student.setCourseId(studentTO.getCourseId());
			student.setRollNo(studentTO.getRollNo());
			student.setStudentClass(studentTO.getStudentClass());

			students.add(student);
		}

		return students;
	}

	@Override
	public Student findById(long id) {
		
		StudentTO studentTO = studentDAO.findOne(id);
		
			Student student = new Student();
			student.setStudentId(studentTO.getStudentId());
			student.setFirstName(studentTO.getFirstName());
			student.setMiddleName(studentTO.getMiddleName());
			student.setLastName(studentTO.getLastName());
			student.setGender(studentTO.getGender());
			student.setDob(studentTO.getDob());
			student.setEmail(studentTO.getEmail());
			student.setMobileNo(studentTO.getMobileNo());
			student.setPassword(studentTO.getPassword());
			student.setCourseId(studentTO.getCourseId());
			student.setRollNo(studentTO.getRollNo());
			student.setStudentClass(studentTO.getStudentClass());

		
		return student;
	}

	@Override
	public void deleteStudentById(Long id) {
		studentDAO.delete(id);
	}

	@Override
	public void updateStudent(Student student) {
		createStudent(student);
		
		
	}

}
