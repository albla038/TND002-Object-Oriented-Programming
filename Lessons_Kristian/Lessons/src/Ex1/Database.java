package Ex1;
import java.io.*;
import java.util.ArrayList;
public class Database {

	private BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in)); 
	private ArrayList<Student> allStudents = new ArrayList<Student>();
	private ArrayList<Exam> allExams = new ArrayList<Exam>(); 
	
	public Database() {
		allStudents = new ArrayList<Student>();
		allExams = new ArrayList<Exam>();
	}
	
	public void addStudent(String arg1, String arg2) {
		allStudents.add(new Student(arg1, arg2));
	}
	
	public String loadStudents(String arg1, int arg2) {
		String[] result;
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(arg1));
			for (int i = 0; i < arg2; i++) {
				result = fileReader.readLine().split(" +");
				addStudent(result[0], result[1]);
			}
			fileReader.close();
			return String.format("Loaded %2d students", arg2);
		}
		catch(IOException ierr) {return "Something went wrong";}
	}
	
	public String addExam(String arg1, int arg2) {
		int maxpoints, minpoints;
		try {
			while (true) {
				try {
					System.out.print("Maximum points possible: ");
					maxpoints = Integer.valueOf(consoleReader.readLine());
					System.out.print("Minimum points possible: ");
					minpoints = Integer.valueOf(consoleReader.readLine());
					allExams.add(new Exam(arg1, arg2, minpoints, maxpoints));
					return String.format("Course: " + arg1 + " added", null);
				}
				catch(NumberFormatException nfe) {} 
			}
		}
		catch(IOException exc) {return "";}
	}
	
	public String checkStudent(int arg) {
		if (arg >= allStudents.size()) return "Student does not exist";
		else return allStudents.get(arg).toString();
		
	}
	
	public String checkExam(int arg) {
		if (arg >= allExams.size()) return "Exam does not exis";
		else return allExams.get(arg).toString();
	}
	
	public String markStudent(String arg1, int arg2, int arg3) {
		Student tempStudent; Exam tempExam; MarkingSheet tempMark;
		for (int i=0; i < allStudents.size(); i++) {
			tempStudent = allStudents.get(i);
			if (arg1.equals(tempStudent.getName())) {
				for (int j=0; j < allExams.size(); j++) {
					tempExam = allExams.get(j);
					if (arg2==tempExam.getCode()) {
						if (arg3<=tempExam.getMaxPoints()) {
							tempMark = new MarkingSheet(arg3,tempExam,tempStudent);
							if (arg3>=tempExam.getMinPoints())
								tempMark.setGrade("G");
							else
								tempMark.setGrade("U");					
							tempStudent.addMarkingSheet(tempMark);
							tempExam.addMarkedStudent(tempMark);
							return String.format("Student%10s got the grade %1s", tempStudent.getName(), tempMark.getGrade());
						}
					}
				}
			}
		}
		return "Could not create marking sheet";
	}
	
	public String toString() {
		String result = "Students\n";
		for (int i=0; i < allStudents.size(); i++) {
			result = result + allStudents.get(i).getName() + "\n";
		}
		result = result + "\nExams\n";
		for (int i = 0; i < allExams.size(); i++) {
			result = result +allExams.get(i).getName() + "\n";
		}
		return result;
	}
}
