package TreeSetWithComparator;

public class Employee implements Comparable<Employee> {

	public Integer eno;
	public String ename;
	public String dept;
	public Integer salary;

	public Employee(Integer eno, String ename, String dept, Integer salary) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.dept = dept;
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee emp) {

		int currentDept = DepartmentMap.getDeptNum(this.dept);
		int empDept = DepartmentMap.getDeptNum(emp.dept);

		int diff = currentDept - empDept;

		if (diff != 0) {
			return diff;
		} else {
			return this.eno - emp.eno;
		}

	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
	

}
