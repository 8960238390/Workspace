package com.tcs.design;

import java.time.LocalDate;

public interface UserDTOBuilder {

	UserDTOBuilder withFirstName(String firstName);
	
	UserDTOBuilder withLastName(String lastName);

	UserDTOBuilder withBirthday(LocalDate date);
	
	UserDTOBuilder withAddress(Address address);
	
	//method to assemble final product
	UserDTO build();
	
	//optional - method to fetch already built object
	UserDTO getUserDTO();
}
