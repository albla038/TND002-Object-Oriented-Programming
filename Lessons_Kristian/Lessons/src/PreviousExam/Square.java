package PreviousExam;

public class Square extends Shape{
	private static Square currentSquare;
	private Square previousSquare;
	private double length;
	
	public Square(double arg) {
		super("Square");
		length = arg;
		computeArea();
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
