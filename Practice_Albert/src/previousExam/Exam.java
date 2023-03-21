package previousExam;

import java.util.ArrayList;

public class Exam {
	private String name;
	private int code, minpoints, maxpoints;
	private ArrayList<MarkingSheet> markedStudents;
	
	public Exam(String inName, int inCode, int inMinpoints, int inMaxpoints) {
		name = inName;
		code = inCode;
		minpoints = inMinpoints;
		maxpoints = inMaxpoints;
		
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
		String result = String.format("%-12s, Code: %4d, Maximum points: %2d, Minimum points: %2d\n",
				getName(), getCode(), getMaxPoints(), getMinPoints());
		
		for (MarkingSheet ms : markedStudents) {
			result += ms.toString() + "\n";
		}
		
		return result;
	}
}
