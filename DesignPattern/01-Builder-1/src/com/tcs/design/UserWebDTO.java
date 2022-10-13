package com.tcs.design;

public class UserWebDTO implements UserDTO{

	private String name;
	private String address;
	private String age;

	public UserWebDTO(String name, String address, String age) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "UserWebDTO [name=" + name + ", address=" + address + ", age=" + age + "]";
	}

	
	
}
