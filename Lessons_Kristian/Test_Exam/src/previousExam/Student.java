package previousExam;

import java.util.ArrayList;

public class Student {
	private ArrayList<MarkingSheet> theExams;
	private String firstName, secondName;
	
	public Student(String arg1, String arg2) {
		firstName = arg1; secondName = arg2;
		theExams = new ArrayList<MarkingSheet>();
	}
	
	public String getName() {
		return secondName;
	}
	
	public void addMarkingSheet(MarkingSheet arg) {
		theExams.add(arg);
	}
	
	public String toString() {
		String result = "";
		
		result += "Student: " + firstName + " " + secondName + "\n";
		
		for (MarkingSheet e : theExams) {
			result += e.getExamName() + ", Grade: " + e.getGrade() + "\n";
		}
		
		return result;
	}
	
}
