package TreeSetWithComparator;

import java.util.TreeSet;

public class MainTest1 {

	public static void main(String[] args) {
		
		//TreeSet<StringBuilder> ts1 = new TreeSet<>();  //it will throw class cast exception 
		TreeSet<StringBuilder> ts1 = new TreeSet<>(new SBComparator());
		
		ts1.add(new StringBuilder("a"));
		ts1.add(new StringBuilder("c"));
		ts1.add(new StringBuilder("b"));
		
		System.out.println(ts1);
	}
}
