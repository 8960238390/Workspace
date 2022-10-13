package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.EligibilityDtlsEntity;

public interface EligibilityDtlsRepository extends JpaRepository<EligibilityDtlsEntity, Integer> {

	//select * from ELIG_DTLS where CASE_NUM = ?
	public EligibilityDtlsEntity findByCaseNum(Integer caseNum );
}
