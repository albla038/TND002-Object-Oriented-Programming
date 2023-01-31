package lecture7;

public class Circle extends Rectangle {
	
	private double r;
	
	public Circle(String arg) { 
		super(arg);
	}
	
	public void setSize(double arg) {
		r = arg;
	}
	
	public double computeArea() {
		area = Math.PI * r*r;
		return area;
	}
}
