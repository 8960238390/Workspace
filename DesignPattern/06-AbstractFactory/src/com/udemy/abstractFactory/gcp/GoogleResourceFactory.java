package com.udemy.abstractFactory.gcp;

import com.udemy.abstractFactory.Instance;
import com.udemy.abstractFactory.Instance.Capacity;
import com.udemy.abstractFactory.ResourceFactory;
import com.udemy.abstractFactory.Storage;

public class GoogleResourceFactory implements ResourceFactory{

	@Override
	public Instance createInstance(Capacity capacity) {
		
		return new GoogleComputeEngineInstance(capacity);
	}

	@Override
	public Storage createStorage(int capMib) {
		
		return new GoogleCloudStorage(capMib);
	}

}
