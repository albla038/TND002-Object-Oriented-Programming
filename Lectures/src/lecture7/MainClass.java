package lecture7;

public class MainClass {

	public static void main(String[] args) {
		
		Rectangle rect = new Rectangle();
		rect.setSize(1.0, 1.0);
		rect.computeArea();
		System.out.println(rect);
		
		Circle c = new Circle("hi2");
		c.setSize(1.0, 1.0);
		c.computeArea();
		System.out.println(c.toString());
		
	}

}
