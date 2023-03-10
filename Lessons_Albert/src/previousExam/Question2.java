package previousExam;

public class Question2 {

	public static void main(String[] args) {
		
		new Circle(1.0);
		new Square(2.0);
		new Circle(2.0);
		new Square(3.0);
		new Circle(1.5);
		new Square(2.2);
		new Square(3.2);
		
		System.out.println(Shape.listShapes());
		
		System.out.println(Shape.sortedListing(Shape.CIRCLE));
		
		System.out.println(Shape.sortedListing(Shape.SQUARE));
		
		Circle c = Circle.getCurrentCircle();
		System.out.println(c.getName());
		while (c.getPreviousCircle() != null) {
			c = c.getPreviousCircle();
			System.out.println(c.getName());
		}
		
		System.out.println();
		
		Square s = Square.getCurrentSquare();
		System.out.println(s.getName());
		while (s.getPreviousSquare() != null) {
			s = s.getPreviousSquare();
			System.out.println(s.getName());
		}
	}

}
