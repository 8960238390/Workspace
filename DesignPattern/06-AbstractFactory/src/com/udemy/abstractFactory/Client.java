package com.udemy.abstractFactory;

import com.udemy.abstractFactory.Instance.Capacity;
import com.udemy.abstractFactory.aws.AwsResourceFactory;
import com.udemy.abstractFactory.gcp.GoogleResourceFactory;

public class Client {

	private ResourceFactory resourceFactory;
	
	public Client(ResourceFactory resourceFactory) {
		
		this.resourceFactory=resourceFactory;
	}
	
	public Instance createServer(Instance.Capacity capacity, int capMib) {
		
		Instance instance = resourceFactory.createInstance(capacity);
		
		Storage storage = resourceFactory.createStorage(capMib);
		
		instance.attachStorage(storage);
		
		return instance;
	}
	
	public static void main(String[] args) {
		
		Client aws = new Client(new AwsResourceFactory());
		
		Instance i1 = aws.createServer(Capacity.micro, 20480);
		
		i1.start();
		i1.stop();
		
		Client google = new Client(new GoogleResourceFactory());
		
		Instance i2 = google.createServer(Capacity.large, 40480);
		i2.start();
		i2.stop();
		
		
		
	}
}
