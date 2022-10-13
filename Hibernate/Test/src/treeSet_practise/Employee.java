
package treeSet_practise;

public class Employee implements Comparable<Employee> {

	int eno;
	String ename;
	String dept;
	double sal;
	double exp;

	public Employee(int eno, String ename, String dept, double sal, double exp) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.dept = dept;
		this.sal = sal;
		this.exp = exp;
	}

	@Override
	public int compareTo(Employee emp) {

		double order = this.exp - emp.exp;

		if (order == 0) {
			return 0;
		} else if (order < 0) {
			return -1;
		} else {
			return 1;
		}

	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", dept=" + dept + ", sal=" + sal + ", exp=" + exp + "]";
	}
	
	

}
