package LinkedHashSet_Practise;
import java.util.LinkedHashSet;

public class School {

	public static void main(String[] args) {
		
		LinkedHashSet<Student> lhs = new LinkedHashSet<>();
		
		lhs.add(new Student(101, "Sharif", "java", 900));
		lhs.add(new Student(102, "baqar", "java", 900));
		
		lhs.add(new Student(101, "sharif", "spring", 1000));
		lhs.add(new Student(102, "baqar", "spring", 1000));
		
		lhs.add(new Student(101, "nitin", "java", 900));
		lhs.add(new Student(102, "ishti", "java", 900));
		
		System.out.println(lhs);
	}
}
