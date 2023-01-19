package lecture3;

public class MainClass {
	
	public static void main(String[] args) {
		
		Human h1 = new Human("Mark");
		Human h2 = new Human("Eric");
		
		System.out.println(h1);
		System.out.println(h2);
		System.out.println("\n");
		
		h1.setToDefault();
		
		System.out.println(h1);
		System.out.println(h2);
		System.out.println("\n");
		
		Human.changeDefault("John Doe");
		
		System.out.println(h1);
		System.out.println(h2);
		System.out.println("\n");
	}

}
