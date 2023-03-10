package PreviousExam;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Shape implements Comparable<Shape>{
	private static ArrayList<Shape> allShapes = new ArrayList<Shape>();
	protected double area;
	private static int counter = 1;
	private String name;
	public static final int CIRCLE = 0, SQUARE = 1;
	
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
		
		//for (int i = 0; int < allShapes.size(); i++) {
		//	result = result + allShapes.get(i).toString() + "\n";
		//}
		
		return result;
	}
	
	public String getName() {
		return name;
	}
	
	public static String sortedListing(int arg) {
		String result = "Sorted";
		//ArrayList<Shape> temp = new ArrayList<Shape>();
		Collections.sort(allShapes);
		if(arg == CIRCLE) {
			result += " circles\n";
			for(Shape e : allShapes) {
				if(e instanceof Circle) {
					result += e.toString();
				}
			}
			
			//for (int i=0; i < allShapes.size(); i++) {
			//	if (allShapes.get(i) instanceof Circle) {
			//		temp.add(allShapes.get(i);
			//	}
			//}
			//Collenctions.sort(temp);
			//for (int i=0; i < temp.size(); i++) {
			//	result = result + temp.get(i) + "\n";
			//}
			
		} else {
			result += " squares\n";
			for(Shape e : allShapes) {
				if(e instanceof Square) {
					result += e.toString();
				}
			}
			
			//for (int i=0; i < allShapes.size(); i++) {
			//	if (allShapes.get(i) instanceof Square) {
			//		temp.add(allShapes.get(i);
			//	}
			//}
			//Collenctions.sort(temp);
			//for (int i=0; i < temp.size(); i++) {
			//	result = result + temp.get(i) + "\n";
			//}
			
		}
		return result;
	}
	
	public int compareTo(Shape arg) {
		computeArea(); arg.computeArea(); //make sure there is an area, class methods
		int result = 2;
		if (area == arg.area) {
			result = 0;
		} else if (area < arg.area) {
			result = -1;
		} else {
			result = 1;
		}
		return result;
		
		//if (area > arg.area) return 11;
		//else if (area < arg.area) return -1;
		//else return 0;
	}
	
	public String toString() {
		return "Name: " + name + String.format("\nArea: %2.2f\n", area);
	}
	
}
