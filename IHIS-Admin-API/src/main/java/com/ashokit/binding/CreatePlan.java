package com.ashokit.binding;

import java.util.Date;

import lombok.Data;

@Data
public class CreatePlan {
	
	private String planName;
	
	private Date planStDate;
	
	private Date planEnDate;
	
	private String planCategory;

}
