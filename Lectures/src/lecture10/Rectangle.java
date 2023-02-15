package lecture10;

public class Rectangle extends Shape {
	
	private int number;
	
	public Rectangle(double arg1, int arg2) { 
		area = arg1; number = arg2;
	}
	
	public int compareTo(Rectangle arg) {
		if (area == arg.area) return 0;
		else if (area < arg.area) return -1;
		else return 1;
	}
	
	public String toString() {
		return String.format("Number: %2d and area: %4.1f", number, area);
	}
}
