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
		while(tempCircle.getPreviousCircle() != null) {
			System.out.println(tempCircle.getPreviousCircle().getName());
			tempCircle = tempCircle.getPreviousCircle();
		}
		
		Square tempSquare = Square.getCurrentSquare();
		System.out.println("\n" + tempSquare.getName());
		while(tempSquare.getPreviousSquare() != null) {
			System.out.println(tempSquare.getPreviousSquare().getName());
			tempSquare = tempSquare.getPreviousSquare();
		}
	}

}
