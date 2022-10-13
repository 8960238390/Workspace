package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		
		List<Integer> al = new ArrayList<>();
		
		al.add(0);
		al.add(10);
		al.add(20);
		al.add(5);
		al.add(15);
		al.add(25);
		
		System.out.println(al);
		
		List<Integer> al2 = new ArrayList<>();		
		
		for(Integer i : al) {
			if(i%2==0) {
				al2.add(i);
			}
		}
		
		System.out.println(al2);
		
		
		List<Integer> al3 = al.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println(al3);
		
		List<Integer> al4 = al.stream().map(i->i*2).collect(Collectors.toList());
		System.out.println(al4);
		
		
	}
}
