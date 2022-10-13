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

@Data
@Entity
@Table(name = "CITIZEN_CHILD_DTLS")
public class CitizenChildDtlsEntity {
	
	@Id
	@Column(name="CHILD_ID")
	private Integer childId;
	
	@Column(name="CASE_NUM")
	private Integer caseNum;
	
	@Column(name="CHILD_NAME")
	private String childName;
	
	@Column(name="CHILD_DOB")
	private LocalDate childDob;

	@Column(unique=true,name="CHILD_SSN")
	private String childZzn;
	
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
