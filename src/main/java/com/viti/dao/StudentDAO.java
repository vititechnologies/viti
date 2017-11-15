package com.viti.dao;

import org.springframework.data.repository.CrudRepository;

import com.viti.dto.StudentTO;
import com.viti.dto.UserTO;

public interface StudentDAO extends CrudRepository<StudentTO, Long> {
	StudentTO findOne(long id);
}
