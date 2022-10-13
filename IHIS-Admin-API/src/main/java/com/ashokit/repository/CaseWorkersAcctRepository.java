package com.ashokit.repository;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.CaseWorkersAcctEntity;

public interface CaseWorkersAcctRepository extends JpaRepository<CaseWorkersAcctEntity, Integer> {
	
	//select * from user_accounts where user_email=? and user_pazzwd=?
		public CaseWorkersAcctEntity findByEmailAndPazzwd(String email,String pazzwd);
		
		//select * from user_accounts where user_email=?
		public CaseWorkersAcctEntity findByEmail(String emailId);

}
