package linkedList;

public class Employee {

	private Integer eno;
	private String ename;
	private double sal;
	
	
	public Employee() {
		super();
	}
	
	public Employee(Integer eno, String ename, double sal) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.sal = sal;
	}
	
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		System.out.println(this);
		System.out.println(obj);
		
		if(obj instanceof Employee) {
			
			Employee emp = (Employee)obj;
			
			return this.eno==emp.eno;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", sal=" + sal + "]";
	}
	
	
	
	
}
