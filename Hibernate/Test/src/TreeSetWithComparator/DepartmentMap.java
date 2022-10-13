package TreeSetWithComparator;
import java.util.HashMap;

public class DepartmentMap {
	
	private static HashMap<String, Integer> deptMap = new HashMap<>();
	
	static {
		deptMap.put("ACCOUNTS", 1);
		deptMap.put("FINANCE", 2);
		deptMap.put("IT", 3);
		deptMap.put("HR", 4);
		deptMap.put("MANAGEMENT", 5);
	}
	
	public static Integer getDeptNum(String deptName) {
		
		return deptMap.get(deptName.toUpperCase());
	}

}
