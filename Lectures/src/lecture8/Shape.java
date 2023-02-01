package lecture8;

public class Shape {
	protected double xPos, yPos;
	
	public Shape() {
		xPos = 0.0; yPos = 0.0;
	}
	
	public Shape(double pos1, double pos2) {
		xPos = pos1; yPos = pos2;
	}
	
	public String toString() {
		return String.format("Position: (%3.1f, %3.1f)", xPos, yPos);  // Superclasses does not now about subclasses,
																	   // and therefore can't use any members from them. Subclasses know about superclasses
	}
}
