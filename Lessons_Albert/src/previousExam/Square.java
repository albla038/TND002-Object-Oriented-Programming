package previousExam;

public class Square extends Shape {
	private static Square currentSquare;
	private Square previousSquare;
	private double length;

	public Square(double inLength) {
		super("Square");
		length = inLength;
		computeArea();
		
		// Build linked list
		previousSquare = currentSquare;
		currentSquare = this;
	}

	public static Square getCurrentSquare() {
		return currentSquare;
	}
	
	public Square getPreviousSquare() {
		return previousSquare;
	}
	
	public void computeArea() {
		area = length * length;
	}
}
