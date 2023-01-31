package lecture7;

public class Rectangle {
	
	protected double xPos, yPos, area;
	private double xLen, yLen;
	
	public Rectangle() {		
		xPos = 1.0; yPos = 1.0;
	}
	
	public Rectangle(String arg) {		
		System.out.println(arg);
		xPos = 2.0; yPos = 2.0;
	}
	
	public void setSize(double arg1, double arg2) {
		if (!(this instanceof Circle)) {	
			xLen = arg1; yLen = arg2;
		}
	}
	
	public double computeArea() {
		area = xLen * yLen;
		return area;
	}
	
	public String toString() {
		return String.format("Position: (%3.1f, %3.1f) and area %3.1f",
				xPos, yPos, area);
	}
	
}
