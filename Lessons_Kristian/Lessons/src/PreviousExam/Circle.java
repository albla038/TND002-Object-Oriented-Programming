package PreviousExam;

public class Circle extends Shape{
	private static Circle currentCircle = null;
	private Circle previousCircle = null;
	private double radius;
	
	public Circle(double arg) {
		super("Circle");
		radius = arg;
		computeArea();
		if(currentCircle != null) previousCircle = currentCircle; //make sure first previous circle is null
		currentCircle = this;
	}
	
	public static Circle getCurrentCircle() {
		return currentCircle;
	}
	
	public Circle getPreviousCircle() {
		return previousCircle;
	}
	
	public void computeArea() {
		area = Math.PI * radius * radius;
	}
}
