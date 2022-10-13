package com.udemy.abstractFactory.aws;

import com.udemy.abstractFactory.Instance;
import com.udemy.abstractFactory.Instance.Capacity;
import com.udemy.abstractFactory.ResourceFactory;
import com.udemy.abstractFactory.Storage;

public class AwsResourceFactory implements ResourceFactory{

	@Override
	public Instance createInstance(Capacity capacity) {
		
		return new Ec2Instance(capacity);
	}

	@Override
	public Storage createStorage(int capMib) {
		
		return new S3Storage(capMib);
	}

}
