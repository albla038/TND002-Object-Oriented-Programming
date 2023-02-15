package lecture10;

public class Circle extends Shape {
	
	private int number;
	
	public Circle(double arg1, int arg2) { 
		area = arg1; number = arg2;
	}
	
	public int compareTo(Circle arg) {
		if (area == arg.area) return 0;
		else if (area < arg.area) return -1;
		else return 1;
	}
	
	public String toString() {
		return super.toString() + String.format(", area = %3.1f", area);
	}
}
