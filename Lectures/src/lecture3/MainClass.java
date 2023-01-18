package lecture3;

public class MainClass {

	public static void main(String[] args) {
		
		Human h1 = new Human();
		Human h2 = new Human("Erik");
		
		h1.setName("Karl");
		h2.setName("Britt");

		System.out.println(h1);
		System.out.println(h2);
	}

}
