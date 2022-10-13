package com.udemy.design;

import java.time.LocalDate;
import java.time.Period;

public class UserDTO {

	private String name;
	
	private String address;
	
	private String age;

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	private void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	private void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", address=" + address + ", age=" + age + "]";
	}
	
	public static UserDTOBuilder getBuilder() {
		return new UserDTOBuilder();
	}


	public static class UserDTOBuilder{
		
		private String firstName;
		private String lastName;
		private String address;
		private String age;
		
		private UserDTO userDTO;
		
		public UserDTOBuilder withFirstName(String firstName) {
			
			this.firstName=firstName;			
			return this;
		}
		
		public UserDTOBuilder withLastName(String lastName) {
			
			this.lastName=lastName;
			return this;
		}
		
		public UserDTOBuilder withAddress(Address address) {
			
			this.address = address.getHouseNumber()+" "+address.getStreet()
			+"\n"+address.getCity()+"\n"+address.getState()+"-"+address.getZipcode();
			
			return this;
		}
		
		public UserDTOBuilder withBirthday(LocalDate date) {
			
			this.age = Integer.toString(Period.between(date, LocalDate.now()).getYears());
			return this;
		}
		
		public UserDTO build() {
			
			this.userDTO = new UserDTO();
			userDTO.setName(this.firstName+" "+this.lastName);
			userDTO.setAge(this.age);
			userDTO.setAddress(this.address);
			
			return userDTO;
		}
		
		public UserDTO getUserDTO() {
			return this.userDTO;
		}
	}
	
}
