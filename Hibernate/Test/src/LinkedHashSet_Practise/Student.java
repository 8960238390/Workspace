package LinkedHashSet_Practise;
public class Student {

	private Integer id;
	private String name;
	private String course;
	private Integer fees;

	public Student(Integer id, String name, String course, Integer fees) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.fees = fees;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getFees() {
		return fees;
	}
	
	public void setFees(Integer fees) {
		this.fees = fees;
	}
	
	@Override
	public int hashCode() {
		
		return CourseMap.getCourseNum(course);
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Student) {
			Student stud =(Student)obj;
			
			return this.course.equals(stud.course) && this.id.equals(stud.getId());
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", fees=" + fees + "]";
	}

}
