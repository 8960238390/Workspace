package LinkedHashSet_Practise;
import java.util.HashMap;

public class CourseMap {
	
	private static HashMap<String, Integer> courseMap = new HashMap<>();
	
	static {
		courseMap.put("JAVA", 1);
		courseMap.put("SPRING", 2);
		courseMap.put("HIBERNATE", 3);
		courseMap.put("REST", 4);
		courseMap.put("MICROSERVICE", 5);
	}
	
	public static Integer getCourseNum(String courseName) {
		
		return courseMap.get(courseName.toUpperCase());
	}

}
