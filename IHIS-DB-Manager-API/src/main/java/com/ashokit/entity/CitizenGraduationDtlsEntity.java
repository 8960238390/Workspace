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
@Table(name = "CITIZEN_GRADUATION_DTLS")
public class CitizenGraduationDtlsEntity {
	
	@Id
	@Column(name="GRADUATION_ID")
	private Integer graduationId;
	
	@Column(name="CASE_NUM")
	private Integer caseNum;
	
	@Column(name="HIGHEST_DEGREE")
	private String highestDegree;
	
	@Column(name="GRADUATION_YEAR_ID")
	private Integer graduationYearId;
	
	@Column(name="UNIVERSITY")
	private String university;
	
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
