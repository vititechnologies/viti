package com.viti.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viti.model.Student;
import com.viti.model.User;
import com.viti.service.StudentService;
import com.viti.service.UserService;

@RestController
public class StudentController {
	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentservice;

	@RequestMapping(value = "/students")
	public List<Student> getStudents() {
		LOG.debug("Entering to get students.");
		List<Student> students = studentservice.getStudents();
		LOG.debug("Student retrieved successfully");
		return students;
	}

	@RequestMapping(value = "/students/{id}")
	public Student getStudent(@PathVariable String id) {
		// Call service method to get one user
		return null;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/students")
	public void addUser(@RequestBody Student student) {
		LOG.info("Entering creating to student");
		studentservice.createStudent(student);
		LOG.info("Successfully created student");
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
	public void update(@RequestBody User user, @PathVariable String id) {
		// Call service method to update user.
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
	public void deleteStudent(@PathVariable String id) {
		// Call service method to delete users.

	}

}
