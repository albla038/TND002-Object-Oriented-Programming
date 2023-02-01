package lecture8;

public class Circle extends Shape {
	
	private double r, area;
	
	public Circle() { 
		super();
		setSize(1.0);
		computeArea();
	}
	
	public Circle(double pos1, double pos2) { 
		super(pos1, pos2);
		setSize(1.0);
		computeArea();
	}
	
	public void setSize(double radius) {
		r = radius;
	}
	
	public double computeArea() {
		area = Math.PI * r*r;
		return area;
	}
	
	public String toString() {
		return super.toString() + String.format(", area = %3.1f", area);
	}
}
