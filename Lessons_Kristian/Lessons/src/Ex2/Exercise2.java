package Ex2;

public class Exercise2 {

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
		while(tempCircle != null) {
			System.out.println(tempCircle.getName());
			tempCircle = tempCircle.getPreviousCircle();
		}
		
		System.out.println();
		
		Square tempSquare = Square.getCurrentSquare();
		while(tempSquare != null) {
			System.out.println(tempSquare.getName());
			tempSquare = tempSquare.getPreviousSquare();
		}
		
	}		
}
