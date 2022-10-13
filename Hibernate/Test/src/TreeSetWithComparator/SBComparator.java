package TreeSetWithComparator;

import java.util.Comparator;

public class SBComparator implements Comparator<StringBuilder>{

	@Override
	public int compare(StringBuilder sb1, StringBuilder sb2) {
		
		String s1 = sb1.toString();
		String s2 = sb2.toString();
		
		return s2.compareTo(s1);
	}

	

}
