package previousExam;

public class MarkingSheet {
	
	private int code;
	private String grade;
	private Exam theExam;
	private Student theStudent;
	
	public MarkingSheet(int inCode, Exam inExam, Student inStudent) {
		code = inCode;
		theExam = inExam;
		theStudent = inStudent;
	}

	public void setGrade(String inGrade) {
		grade = inGrade;
	}

	public int getCode() {
		return code;
	}

	public String getGrade() {
		return grade;
	}
	
	public String getExamName() {
		return theExam.getName();
	}
	
	public String getStudentName() {
		return theStudent.getName();
	}
	
	public String toString() {
		return "Student: " + theStudent.getName() + " Grade: " + grade;
	}
}
