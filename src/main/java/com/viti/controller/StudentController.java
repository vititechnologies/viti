package com.viti.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viti.model.Student;

@RestController
public class StudentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@RequestMapping(value = "/student")
	public List<Student> getStudent(){

		List<Student> student = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		cal.set(1976, 4, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Student s = new Student("Akash","D","Bhalke", "Male", sdf.format(cal.getTime()), "akash.bhalke@viti.com");
		student.add(s);
		LOGGER.debug("Student added successfully");
		return student;
	}




}
