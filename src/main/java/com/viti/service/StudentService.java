package com.viti.service;

import java.util.List;

import com.viti.model.Student;


public interface StudentService {
	
	
	public void createStudent(Student student);

	
	public List<Student> getStudents();

}
