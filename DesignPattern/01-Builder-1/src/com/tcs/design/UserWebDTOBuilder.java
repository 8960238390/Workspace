package com.tcs.design;

import java.time.LocalDate;
import java.time.Period;

public class UserWebDTOBuilder implements UserDTOBuilder{

	private String firstName;
	private String lastName;
	private String age;
	private String address;
	private UserWebDTO userWebDTO;

	@Override
	public UserDTOBuilder withFirstName(String firstName) {
		
		this.firstName=firstName;
		
		return this;
	}
	@Override
	public UserDTOBuilder withLastName(String lastName) {

		this.lastName=lastName;
		
		return this;
	}
	@Override
	public UserDTOBuilder withBirthday(LocalDate date) {

		Period ageInYears = Period.between(date, LocalDate.now());
		this.age=Integer.toString(ageInYears.getYears());
		
		return this;
	}
	@Override
	public UserDTOBuilder withAddress(Address address) {
		
		this.address=address.getHouseNumber()+" "+address.getStreet()
		+"\n"+address.getCity()+"\n"+address.getState()+"-"+address.getZipcode();
		
		return this;
	}
	@Override
	public UserDTO build() {
		
		this.userWebDTO = new UserWebDTO(this.firstName+" "+this.lastName, address, age);
		
		return this.userWebDTO;
	}
	@Override
	public UserDTO getUserDTO() {
		// TODO Auto-generated method stub
		return this.userWebDTO;
	}
	
}