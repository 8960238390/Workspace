package com.ashokit.binding;

import java.util.Date;

import lombok.Data;

@Data
public class CreateAccount {

	private String fullName;

	private String emailId;

	private int mobileNum;

	private char gender;

	private Date dob;

	private int SSN;
	
	private String pazzwd;

}
