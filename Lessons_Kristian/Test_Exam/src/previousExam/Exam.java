package previousExam;

import java.util.ArrayList;

public class Exam {
	private String name;
	private int code, minpoints, maxpoints;
	private ArrayList<MarkingSheet> markedStudents;
	
	public Exam(String arg1, int arg2, int arg3, int arg4){
		name = arg1; code = arg2; maxpoints = arg3; minpoints = arg4;
		markedStudents = new ArrayList<MarkingSheet>();
	}
	
	public int getMaxPoints() {
		return maxpoints;
	}
	
	public int getMinPoints() {
		return minpoints;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public void addMarkedStudent(MarkingSheet arg) {
		markedStudents.add(arg);
	}
	
	public String toString() {
		String result = "";
		
		result += String.format("%-12s, Code: %4d, Maximum points: %2d, Minimum points: %2s\n", name, code, maxpoints, minpoints);
		
		for (MarkingSheet e : markedStudents) {
			result += e.toString() + "\n";
		}
		
		return result;
	}
	
}
