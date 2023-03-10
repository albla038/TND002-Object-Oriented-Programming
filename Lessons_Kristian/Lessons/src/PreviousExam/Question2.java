package PreviousExam;

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
	
		Circle tempCircle = Circle.getCurrentCircle();
		System.out.println(tempCircle.getName());
		do {
			tempCircle = tempCircle.getPreviousCircle();
			System.out.println(tempCircle.getName());
		} while(tempCircle.getPreviousCircle() != null);
		
		Square tempSquare = Square.getCurrentSquare();
		System.out.println("\n" + tempSquare.getName());
		do {
			tempSquare = tempSquare.getPreviousSquare();
			System.out.println(tempSquare.getName());
		} while(tempSquare.getPreviousSquare() != null);
		
		// System.out.println(Circle.getCurrentCircle().getName());
		// System.out.println(Cricle.getCurrentCircle().getPreviousCircle().getName());
		// System.out.println(Cricle.getCurrentCircle().getPreviousCircle().getPreviousCircle().getName());
	}

}
