package TreeSetWithComparator;

import java.util.TreeSet;

public class MainTest {

	public static void main(String[] args) {
		
		TreeSet<String> ts1 = new TreeSet<>();
		
		ts1.add("a");
		ts1.add("c");
		ts1.add("b");
		
		System.out.println(ts1);
		
		TreeSet<String> ts2 = new TreeSet<>(new StringComparator());
		ts2.add("a");
		ts2.add("c");
		ts2.add("b");
		System.out.println(ts2);
		
	}
}
