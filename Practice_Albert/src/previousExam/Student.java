package previousExam;

import java.util.ArrayList;

public class Student {
	
	private ArrayList<MarkingSheet> theExams;
	private String firstName, secondName;
	
	public Student(String inFirstName, String inSecondName) {
		firstName = inFirstName;
		secondName = inSecondName;
		
		theExams = new ArrayList<MarkingSheet>();
	}
	
	public String getName() {
		return secondName;
	}
	
	public void addMarkingSheet(MarkingSheet arg) {
		theExams.add(arg);
	}
	
	public String toString() {
		String result = "Student: " + firstName + " " + secondName + ":\n";
		
		for (MarkingSheet markingSheet : theExams) {
			result += markingSheet.getExamName() + ", Grade: " + markingSheet.getGrade() + "\n";
		}
		return result;
	}
}
