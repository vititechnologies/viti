package com.viti.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.viti.dto.StaffTO;

@Transactional
public interface StaffDAO extends CrudRepository<StaffTO, Long> {

}

