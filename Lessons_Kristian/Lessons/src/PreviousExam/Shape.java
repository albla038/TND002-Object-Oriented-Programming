package PreviousExam;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Shape implements Comparable<Shape>{
	private static ArrayList<Shape> allShapes = new ArrayList<Shape>();
	protected double area;
	private static int counter = 1;
	private String name;
	public static int CIRCLE = 0, SQUARE = 1;
	
	public Shape(String arg) {
		name = arg + counter;
		counter++;
		allShapes.add(this);
	}
	
	public abstract void computeArea();
	
	public static String listShapes() {
		String result = "List of shapes:\n";
		
		for(Shape e : allShapes) {
			result += e.toString();
		}
		
		return result;
	}
	
	public String getName() {
		return name;
	}
	
	public static String sortedListing(int arg) {
		String result = "Sorted";
		Collections.sort(allShapes);
		if(arg == CIRCLE) {
			result += " circles\n";
			for(Shape e : allShapes) {
				if(e instanceof Circle) {
					result += e.toString();
				}
			}
			
		} else {
			result += " squares\n";
			for(Shape e : allShapes) {
				if(e instanceof Square) {
					result += e.toString();
				}
			}
		}
		return result;
	}
	
	public int compareTo(Shape arg) {
		int result = 2;
		if (area == arg.area) {
			result = 0;
		} else if (area < arg.area) {
			result = -1;
		} else {
			result = 1;
		}
		return result;
	}
	
	public String toString() {
		return "Name: " + name + String.format("\nArea: %2.2f\n", area);
	}
	
}
