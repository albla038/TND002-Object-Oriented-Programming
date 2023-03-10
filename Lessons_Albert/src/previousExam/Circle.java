package previousExam;

public class Circle extends Shape {
	private static Circle currentCircle;
	private Circle previousCircle;
	private double radius;

	public Circle(double inRadius) {
		super("Circle");
		radius = inRadius;
		computeArea();
		
		// Build linked list
		previousCircle = currentCircle;
		currentCircle = this;
	}

	public static Circle getCurrentCircle() {
		return currentCircle;
	}
	
	public Circle getPreviousCircle() {
		return previousCircle;
	}
	
	public void computeArea() {
		area = Math.PI * radius*radius;
	}
}
