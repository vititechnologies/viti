package com.viti.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.viti.model.Student;
import com.viti.model.User;
import com.viti.service.StudentService;
import com.viti.service.UserService;

@RestController
public class StudentController {
	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentservice;
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView studentRegistration(){
		ModelAndView modelAndView = new ModelAndView();
		Student student = new Student();
		 List<Student> list=studentservice.getStudents();
     	modelAndView.addObject("student1", list);
		 modelAndView.addObject("student", student);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewStudent(@Valid Student student, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		    studentservice.createStudent(student);
		    List<Student> list=studentservice.getStudents();
	     	modelAndView.addObject("student1", list);
			modelAndView.addObject("successMessage", "Student has been registered successfully");
			modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/studentUpdate/{id}")
	public ModelAndView update(@Valid Student student, @PathVariable long id) {
		 Student currentStudent = studentservice.findById(id);
		     currentStudent.setStudentId(student.getStudentId());
	        currentStudent.setFirstName(student.getFirstName());
	        currentStudent.setMiddleName(student.getMiddleName());
	        currentStudent.setLastName(student.getLastName());
	        currentStudent.setGender(student.getGender());
	        currentStudent.setDob(student.getDob());
	        currentStudent.setEmail(student.getEmail());
	        currentStudent.setMobileNo(student.getMobileNo());
	        currentStudent.setPassword(student.getPassword());
	        currentStudent.setCourseId(student.getCourseId());
	        currentStudent.setRollNo(student.getRollNo());
	        currentStudent.setStudentClass(student.getStudentClass());
	        currentStudent.setEmail(student.getEmail());
	       
		studentservice.updateStudent(currentStudent);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/registration");
		return modelAndView;
	
	}
	
	@RequestMapping(value = "delete/students/{id}" ,method = RequestMethod.GET)
	public ModelAndView deleteStudentt(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView();
		studentservice.deleteStudentById(id);
		modelAndView.setViewName("redirect:/registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/updateStudent/{id}" , method = RequestMethod.GET)
	public ModelAndView updateStudent(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView();
		Student student = studentservice.findById(id);
		 modelAndView.addObject("student",student);
		modelAndView.setViewName("updateStudent");
		return modelAndView;
	}
	
	@RequestMapping(value = "/students")
	public List<Student> getStudents() {
		LOG.debug("Entering to get students.");
		List<Student> students = studentservice.getStudents();
		LOG.debug("Student retrieved successfully");
		return students;
	}

	@RequestMapping(value = "/students/{id}")
	public Student getStudent(@PathVariable long id) {
		Student student = studentservice.findById(id);
		return student;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/students")
	public void addUser(@RequestBody Student student) {
		LOG.info("Entering creating to student");
		studentservice.createStudent(student);
		LOG.info("Successfully created student");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
	public void deleteStudent(@PathVariable long id) {
		studentservice.deleteStudentById(id);

	}

}
