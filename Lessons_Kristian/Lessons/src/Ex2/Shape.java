package Ex2;
import java.util.ArrayList;
import java.util.Collections;
public abstract class Shape implements Comparable<Shape>{

	private static ArrayList<Shape> allShapes= new ArrayList<Shape>();
	protected double area;
	private static int counter = 1;
	private String name;
	public final static int CIRCLE=0, SQUARE = 1;
	
	public Shape(String arg) {
		name = arg + counter; counter = counter + 1;
		allShapes.add(this);
	}
	
	public abstract void computeArea();
	
	public String getName() {return name;}
	
	public int compareTo(Shape arg) {
		computeArea(); arg.computeArea();
		if (area > arg.area) return 1;
		else if (area < arg.area) return -1;
		else return 0;		
	}
	
	public static String listShapes() {
		String result = "List of shapes\n";
		for (int i = 0; i < allShapes.size(); i++) {
			result = result + allShapes.get(i).toString() + "\n";
		}
		return result;
	}	
	
	public static String sortedListing(int arg) {
		ArrayList<Shape> temp = new ArrayList<Shape>();
		String result="";
		if (arg == CIRCLE) {
			for (int i=0; i < allShapes.size(); i++) {
				if (allShapes.get(i) instanceof Circle) {
					temp.add(allShapes.get(i));
				}
			}
			Collections.sort(temp);
			for (int i=0; i < temp.size(); i++) {
				result = result + temp.get(i) + "\n";
			}
		}
		else {
			for (int i=0; i < allShapes.size(); i++) {
				if (allShapes.get(i) instanceof Square) {
					temp.add(allShapes.get(i));
				}
			}
			Collections.sort(temp);
			for (int i=0; i < temp.size(); i++) {
				result = result + temp.get(i) + "\n";
			}
		}
		return result;
	}
	
	public String toString() {
		return "Name: " + name + String.format("Area: %5.2f", area);
	}
}
