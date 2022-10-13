package com.udemy.abstractFactory.gcp;

import com.udemy.abstractFactory.Instance;
import com.udemy.abstractFactory.Storage;

public class GoogleComputeEngineInstance implements Instance{

	public GoogleComputeEngineInstance(Capacity capacity) {
		
		System.out.println("Created Google Compute Engine instance with capacity : "+capacity);
	}
	
	@Override
	public void start() {
		
		System.out.println("compute engine instance stared");
	}

	@Override
	public void stop() {
		
		System.out.println("Compute engine instace stoped");
	}

	@Override
	public void attachStorage(Storage storage) {
		
		System.out.println("Attached "+storage+" to compute engine instances");
	}

}
