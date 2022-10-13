package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.CitizenEducationDtlsEntity;

public interface CitizenEducationDtlsRepository extends JpaRepository<CitizenEducationDtlsEntity, Integer> {

	public CitizenEducationDtlsEntity findByCaseNum(Integer caseNum);
}
