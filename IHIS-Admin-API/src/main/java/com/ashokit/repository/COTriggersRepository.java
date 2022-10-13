package com.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.COTriggersEntity;

public interface COTriggersRepository extends JpaRepository<COTriggersEntity, Integer> {

	//select * from COTriggersEntity where trgStatus = ?
	public List<COTriggersEntity> findByTrgStatus(String status);
	
}
