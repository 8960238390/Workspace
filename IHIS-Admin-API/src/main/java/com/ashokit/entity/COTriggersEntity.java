package com.ashokit.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "CO_TRIGGERS")
public class COTriggersEntity {

	@Id
	@Column(name="TRG_ID")
	private Integer trgId;
	
	@Column(name="CASE_NUM")
	private Integer caseNum;
	
	@Column(name="TRG_STATUS")
	private String trgStatus;
	
	@Column(name="NOTICE")
	@Lob
	private byte[] notice;
}
