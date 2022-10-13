package linkedList;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<Employee> al = new ArrayList<>();
		
		al.add(new Employee(101,"sharif",30000));
		al.add(new Employee(102,"Murtaza",50000));
		al.add(new Employee(103,"Ishti",30000));
		
		System.out.println(al.contains(new Employee(102,"Murtaza",50000)));
		
	}
}
