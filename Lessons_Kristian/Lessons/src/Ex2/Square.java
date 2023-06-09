package Ex2;

public class Square extends Shape {

	private static Square currentSquare=null;
	private Square previousSquare=null;
	private double length;
	
	public Square(double arg) {
		super("Square");
		if (currentSquare != null) previousSquare = currentSquare;
		currentSquare = this;
		length = arg; computeArea();
	}
	
	public static Square getCurrentSquare() {
		return currentSquare;
	}
	
	public Square getPreviousSquare() {
		return previousSquare;
	}
	
	public void computeArea() {
		area = length*length;
	}
}