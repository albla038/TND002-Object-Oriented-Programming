package previousExam;

import java.util.ArrayList;

public class Exam {

	private String name;
	private int code, minPoints, maxPoints;
	private ArrayList<MarkingSheet> markedStudents;
	
	public Exam(String inName, int inCode, int inMinPoints, int inMaxPoints) {
		name = inName;
		code = inCode;
		minPoints = inMinPoints;
		maxPoints = inMaxPoints;
		
		markedStudents = new ArrayList<MarkingSheet>();
	}
	
	public int getMaxPoints() {
		return maxPoints;
	}
	
	public int getMinPoints() {
		return minPoints;
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
		String result = String.format("%12s, Code: %4d, Maximum points: %2d, Minimum points: %2d\n",
										name, code, maxPoints, minPoints);
		
		for (MarkingSheet e : markedStudents) {
			result += e.toString() + "\n";
		}
		
		return result;
	}
}
