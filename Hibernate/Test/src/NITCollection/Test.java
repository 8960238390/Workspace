package NITCollection;

public class Test {

	public static void main(String[] args) {
		
		NITCollection col = new NITCollection();
		
		System.out.println("capacity : "+col.capacity());
		System.out.println("size : "+col.size());
		System.out.println("element : "+col);
		
		col.add("a");
		col.add("b");
		col.add("c");
		col.add("d");
		col.add("e");
		col.add("f");
		col.add(1);
		col.add(2);
		col.add(3);
		col.add(4);
		
		System.out.println("capacity : "+col.capacity());
		System.out.println("size : "+col.size());
		System.out.println("element : "+col);		
		
		
		
		col.add(5);
		
		System.out.println("capacity : "+col.capacity());
		System.out.println("size : "+col.size());
		System.out.println("element : "+col);
		
		col.insert(3, true);
		
		col.remove(4);
		
		System.out.println("capacity : "+col.capacity());
		System.out.println("size : "+col.size());
		System.out.println("element : "+col);
		
	}
}
