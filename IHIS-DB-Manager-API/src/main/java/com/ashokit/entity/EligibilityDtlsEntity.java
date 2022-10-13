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
@Table(name = "ELIG_DTLS")
public class EligibilityDtlsEntity {

	@Id
	@Column(name="ELIG_ID")
	private Integer eligId;
	
	@Column(name="CASE_NUM")
	private String caseNum;
	
	@Column(name="PLAN_NAME")
	private Integer planName;
	
	@Column(name="PLAN_STATUS")
	private String planStatus;
	
	@Column(name="START_DATE")
	private Date startDate;
		
	@Column(name="END_DATE")
	private Date endDate;
	
	@Column(name="BENEFIT_AMT")
	private Integer benifitAmt;
	
	@Column(name="DENIAL_REASON")
	private String DenialReason;
	
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
