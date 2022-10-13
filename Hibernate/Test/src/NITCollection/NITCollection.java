package NITCollection;

import java.util.Arrays;

public class NITCollection {

	private Object[] objArray = new Object[10];
	
	private int index=0;
	
	public void add(Object ele) {
		
		if(size()==capacity()) {
			incrementalCapacity();
		}
		
		objArray[index]=ele;
		index++;
	}

	public int size() {
		return this.index;
	}
	
	public int capacity() {
		return this.objArray.length;
	}
	
	public void incrementalCapacity() {
		
		Object[] tempArray = new Object[capacity()*2];
		
		for(int i=0 ; i<objArray.length ; i++) {
			tempArray[i] = objArray[i];
		}
		
		objArray=tempArray;
	}
	
	
	public Object get(int index) {
		return objArray[index];
	}
	
	public void replace(int index,Object ele) {
		objArray[index] = ele;
	}
	
	public void remove(int i) {
		
		for(;i<size()-1;i++) {
			objArray[i] = objArray[i+1];
		}
		
		objArray[i]=null;
		index--;
	}
	
	public void insert(int i , Object ele) {
		
		if(size() == capacity()) {
			incrementalCapacity();
		}
		
		for(int j=size()-1; j>=i ; j--) {
			objArray[j+1]=objArray[j];
		}
		
		objArray[i]=ele;
		index++;
	}

	@Override
	public String toString() {
		return "NITCollection [objArray=" + Arrays.toString(objArray) + "]";
	}

	
}

