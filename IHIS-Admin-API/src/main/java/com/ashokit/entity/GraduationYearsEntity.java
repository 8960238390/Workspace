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
@Table(name = "GRADUATION_YEARS")
public class GraduationYearsEntity {
	
	@Id
	@Column(name="YEAR_ID")
	private Integer yearId;
	
	@Column(name="YEAR")
	private Integer year;

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
