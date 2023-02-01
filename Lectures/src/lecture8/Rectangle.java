package lecture8;

public class Rectangle extends Shape {
	
	private double xLen, yLen, area;
	
	public Rectangle() {	
		super();				//Explicit call to super().
		setSize(1.0, 1.0);
		computeArea();
	}
	
	public Rectangle(double pos1, double pos2) {		
		super(pos1, pos2);
		setSize(1.0, 1.0);
		computeArea();
	}
	
	public void setSize(double len1, double len2) {	
		xLen = len1; yLen = len2;
	}
	
	public double computeArea() {
		area = xLen * yLen;
		return area;
	}
	
	public String toString() {
		return super.toString() + String.format(", area = %3.1f", area);
	}
	
}
