package com.tcs.design;

import java.time.LocalDate;

public class Client {

	public static void main(String[] args) {
		
		User user = createUser();
		UserWebDTOBuilder builder = new UserWebDTOBuilder();
		
		UserDTO dto = directBuild(builder, user);
		System.out.println(dto);
		
	}
	
	private static UserDTO directBuild(UserDTOBuilder builder, User user) {
		
		return builder.withFirstName(user.getFirstName()).withLastName(user.getLastName())
		.withBirthday(user.getBirthDay()).withAddress(user.getAddress()).build();
	}

	public static User createUser() {
		
		User user = new User();
		
		user.setFirstName("Mohammad");
		user.setLastName("Sharif");
		user.setBirthDay(LocalDate.of(1994,9,22));
		Address address = new Address();
		address.setHouseNumber("437/18");
		address.setStreet("kareemganj");
		address.setCity("Lucknow");
		address.setState("U.P");
		address.setZipcode("226003");
		
		user.setAddress(address);
		
		return user;
	}
}
