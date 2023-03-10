package previousExam;

import java.util.*;

public abstract class Shape implements Comparable<Shape> {
	private static ArrayList<Shape> allShapes = new ArrayList<Shape>();
	protected double area;
	private static int counter = 1;
	private String name;
	public static final int CIRCLE = 0, SQUARE = 1;
	
	public Shape(String inName) {
		name = inName + counter++;
		allShapes.add(this);
	}
	
	public abstract void computeArea();
	
	public static String listShapes() {
		String result = "List of shapes: \n";
		for (Shape s : allShapes) {
			result += s.toString() + "\n";
		}
		
		return result;
	}
	
	public String getName() {
		return name;
	}
	
	public static String sortedListing(int shapeArg) {
		Collections.sort(allShapes);
		String result;
		
		if (shapeArg == CIRCLE) {
			result = "Sorted circles\n";
			for (Shape s : allShapes) {
				if (s instanceof Circle) {
					result += s.toString() + "\n";
				}
			}
		} else if (shapeArg == SQUARE) {
			result = "Sorted squares\n";
			for (Shape s : allShapes) {
				if (s instanceof Square) {
					result += s.toString() + "\n";
				}
			}
		} else {
			result = "Something went wrong";
		}
		
		return result;
	}
	
	public int compareTo(Shape arg) {
		//TODO computeArea?
		if (area < arg.area) {
			return -1;
		} else if (area == arg.area) {
			return 0;
		}
		
		return 1;
	}
	
	public String toString() {
		return String.format("Name: %s\nArea: %5.2f", name, area);
	}
}
