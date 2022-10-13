package TreeSetWithComparator;

import java.util.Comparator;
import java.util.TreeSet;

public class DeptTest {

	public static void main(String[] args) {

		TreeSet<Employee> ts1 = new TreeSet<>();

		ts1.add(new Employee(101, "sharif", "it", 3000));
		ts1.add(new Employee(102, "baqar", "accounts", 5000));
		ts1.add(new Employee(103, "saurabh", "management", 3000));
		ts1.add(new Employee(104, "ishti", "it", 4000));

		System.out.println(ts1);

		Comparator<Employee> comp = (e1, e2) -> {

			return e2.compareTo(e1);
		};

		TreeSet<Employee> ts2 = new TreeSet<>(comp);
		ts2.add(new Employee(101, "sharif", "it", 3000));
		ts2.add(new Employee(102, "baqar", "accounts", 5000));
		ts2.add(new Employee(103, "saurabh", "management", 3000));
		ts2.add(new Employee(104, "ishti", "it", 4000));

		System.out.println(ts2);

		Comparator<Employee> comp1 = (e1, e2) -> {

			int salDiff = e1.salary - e2.salary;

			if (salDiff != 0) {

				return salDiff;
			} else {

				return (e1.eno < e2.eno) ? -1 : (e1.eno > e2.eno) ? 1 : 0;
			}
		};

		TreeSet<Employee> ts3 = new TreeSet<>(comp1);
		ts3.add(new Employee(101, "sharif", "it", 3000));
		ts3.add(new Employee(102, "baqar", "accounts", 5000));
		ts3.add(new Employee(103, "saurabh", "management", 3000));
		ts3.add(new Employee(104, "ishti", "it", 4000));
		System.out.println(ts3);

	}

}
