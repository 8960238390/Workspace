package com.ashokit.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.JpaRepository;

import lombok.Data;

@Entity
@Table(name = "CITIZEN_APPS")
@Data
public class CitizenAppsEntity {

	@Id
	@Column(name="CASE_NUM")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer caseNum;
	
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
	private LocalDate dob;
	
	@Column(unique=true,name="SSN")
	private Integer zzn;
	
	@Column(name="STATE_NAME")
	private String stateName;
	
	@Column(name="ACTIVE_SW")
	private Character activeSw;
	
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
