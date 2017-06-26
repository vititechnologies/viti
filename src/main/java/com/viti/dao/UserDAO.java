package com.viti.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.viti.dto.UserTO;

@Transactional
public interface UserDAO extends CrudRepository<UserTO, Long>{
}
