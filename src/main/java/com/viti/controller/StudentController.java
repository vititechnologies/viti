package com.viti.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viti.model.Student;

@RestController
public class StudentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	private List<Student> student = new ArrayList<>(
			Arrays.asList(new Student("Akash", "D", "Bhalke", "Male", "16/04/1992", "akash@viti.com")));

	@RequestMapping(value = "/student")
	public List<Student> getStudent() {
		LOGGER.debug("Student added successfully");
		return student;
	}

	@RequestMapping(value = "/student/{id}")
	public Student getStudent(@PathVariable String id) {

		return student.stream().filter(t -> t.getFirstName().equals(id)).findFirst().get();

	}

	@RequestMapping(method = RequestMethod.POST, value = "/student")
	public void addStudent(@RequestBody Student students) {

		student.add(students);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/student/{id}")
	public void updateStudent(@RequestBody Student students, @PathVariable String id) {

		for (int i = 0; i < student.size(); i++) {
			Student s = student.get(i);
			if (s.getFirstName().equals(id)) {
				student.set(i, (Student) students);
			}
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/student/{id}")
	public void deleteStudent(@PathVariable String id) {
		student.removeIf(t -> t.getFirstName().equals(id));

	}
	/*
	 * private List<Student> student = new ArrayList<>();
	 * 
	 * @RequestMapping(value = "/student") public List<Student> getStudent(){
	 * 
	 * //List<Student> student = new ArrayList<>(); Calendar cal =
	 * Calendar.getInstance(); cal.set(1976, 4, 1); SimpleDateFormat sdf = new
	 * SimpleDateFormat("dd/MM/yyyy"); Student s = new
	 * Student("Akash","D","Bhalke", "Male", sdf.format(cal.getTime()),
	 * "akash.bhalke@viti.com"); student.add(s);
	 * LOGGER.debug("Student added successfully"); return student; }
	 * 
	 * @RequestMapping(value = "/student/{id}") public Student
	 * getStudent(@PathVariable("id") String id){ return student.get(1); }
	 */

}
