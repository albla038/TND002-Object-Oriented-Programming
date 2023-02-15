package lecture10;

public abstract class Shape implements Comparable<Shape> {
	protected double area;
	
	public int compareTo(Shape arg) {
		if (area == arg.area) return 0;
		else if (area < arg.area) return -1;
		else return 1;
	}
}
