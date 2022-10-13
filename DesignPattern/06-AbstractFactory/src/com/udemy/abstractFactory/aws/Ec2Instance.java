package com.udemy.abstractFactory.aws;

import com.udemy.abstractFactory.Instance;
import com.udemy.abstractFactory.Storage;

public class Ec2Instance implements Instance{
	
	public Ec2Instance(Capacity capacity) {
		
		System.out.println("Created Ec2Instance with capacity : "+capacity);
	}

	@Override
	public void start() {
		
		System.out.println("Ec2Instance stared");
	}

	@Override
	public void stop() {
		
		System.out.println("Ec2Instance stopped");
	}

	@Override
	public void attachStorage(Storage storage) {
		
		System.out.println("Attached "+storage+" to Ec2Instances");
	}

	@Override
	public String toString() {
		return "Ec2Instance";
	}

	
}
