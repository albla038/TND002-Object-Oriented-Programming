package Ex2;

public class Circle extends Shape {

	private static Circle currentCircle=null;
	private Circle previousCircle=null;
	private double radius;
	
	public Circle(double arg) {
		super("Circle");
		if (currentCircle != null) previousCircle = currentCircle;
		currentCircle = this;
		radius = arg; computeArea();
	}
	
	public static Circle getCurrentCircle() {
		return currentCircle;
	}
	
	public Circle getPreviousCircle() {
		return previousCircle;
	}
	
	public void computeArea() {
		area = Math.PI*radius*radius;
	}
}
