package com.udemy.design;

import java.time.LocalDate;

import com.udemy.design.UserDTO.UserDTOBuilder;

public class Client {

	public static void main(String[] args) {
		
		User user=createUser();
		
		UserDTO dto = directBuild(UserDTO.getBuilder(), user);
		
		System.out.println(dto);
	}
	
	private static UserDTO directBuild(UserDTOBuilder builder, User user) {
		
		return builder.withFirstName(user.getFirstName()).withLastName(user.getLastName())
		.withAddress(user.getAddress()).withBirthday(user.getBirthDay()).build();
	}
	
	public static User createUser() {
		User user = new User();
		user.setBirthDay(LocalDate.of(1997, 9, 22));
		user.setFirstName("Ron");
		user.setLastName("Swanson");
		Address address = new Address();
		address.setHouseNumber("100");
		address.setStreet("State Street");
		address.setCity("Pawnee");
		address.setState("Indiana");
		address.setZipcode("47998");
		user.setAddress(address);
		return user;
	}
}
