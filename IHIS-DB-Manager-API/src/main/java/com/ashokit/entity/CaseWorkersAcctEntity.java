package com.ashokit.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "CW_ACCOUNTS")
public class CaseWorkersAcctEntity {
	
	@Id
	@Column(name="ACCT_ID")
	private Integer acctId;
	
	@Column(name="FULLNAME")
	private String fullName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PAZZWD")
	private String pazzwd;
	
	@Column(name="MOBILE_NUM")
	private Integer mobileNum;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(unique=true,name="SSN")
	private Integer ssn;
	
	@Column(name="ACTIVE_SW")
	private Character activeSw;
	
	@Column(name = "ACC_STATUS")
	private String accStatus;
	
	@Column(name ="CREATE_DATE" , updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name ="UPDATED_DATE" , insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;

}
