package lecture8;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		Shape myShape = new Shape(2.0, 2.0);
		System.out.println(myShape);
		
		Rectangle myRectangle = new Rectangle(1.0, 1.5);
		System.out.println(myRectangle);
		
		Circle myCircle = new Circle(1.0, 2.0);
		System.out.println(myCircle);
		*/
		
		//Base b = new Base();
		//Derived d = new Derived();
		
		
		Base b = new Derived(); 	// works
		Derived d = new Derived();  // works
		//Derived d = new Base();	// Doesn't work
		
		
		System.out.println(b.methodA());
		//System.out.println(b.methodB());
	}

}
