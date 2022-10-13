package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.CitizenIncomeDtlsEntity;

public interface CitizenIncomeDtlsRepository extends JpaRepository<CitizenIncomeDtlsEntity, Integer> {
	
	public CitizenIncomeDtlsEntity findByCaseNum(Integer caseNum);
	
}
