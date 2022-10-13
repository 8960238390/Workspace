package treeSet_practise;

import java.util.TreeSet;

public class TestMain {

	public static void main(String[] args) {
		
		TreeSet<Employee> ts = new TreeSet<>();
		
		
		ts.add(new Employee(101, "sharif", "banking", 1000000, 2.5));
		ts.add(new Employee(102, "Baqar", "banking", 52222, 1));
		ts.add(new Employee(103, "ishti", "ecommerce", 20000, 1.5));
		ts.add(new Employee(104, "saurabh", "ecommerce", 512463, 2));
		
		System.out.println(ts);
		
	}
}
