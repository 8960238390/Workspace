package com.ashokit.binding;

import lombok.Data;

@Data
public class UnlockAccForm {
	
	private String email;
	
	private String tempPazz;
	
	private String newPazz;
	
	private String confirmNewPazz;

}
