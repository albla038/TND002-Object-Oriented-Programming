package previousExam;

import java.util.ArrayList;
import java.io.*;

public class Database {
	private ArrayList<Student> allStudents;
	private ArrayList<Exam> allExams;
	private BufferedReader consoleReader;
	
	public Database() {
		allStudents = new ArrayList<Student>();
		allExams = new ArrayList<Exam>();
		consoleReader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void addStudent(String arg1, String arg2) {
		allStudents.add(new Student(arg1, arg2));
	}
	
	public String loadStudents(String arg1, int arg2) {
		String result = "";
		//System.out.print(arg2);
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(arg1));
			result = String.format("Loaded %2d students", arg2);
			
			for(int i = 0; i < arg2; i++) {
				String[] temp = fileReader.readLine().split(" +");
				addStudent(temp[0], temp[1]);
			}
			
			fileReader.close();
		} catch (IOException e){
			result = "Something went wrong (db)";
		}
		
		return result;
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
					allExams.add(new Exam(arg1, arg2, maxpoints, minpoints));
					return "Course " + arg1 + " added";
				} catch (NumberFormatException i) {
					;
				}
			}
		} catch (IOException e) {
			return "Something went wrong (IOException)";
		}	
	}
	
	public String checkStudent(int arg) {
		if(arg >= allStudents.size()) return "Student does not exist";
		else return allStudents.get(arg).toString();
	}
	
	public String checkExam(int arg) {
		if(arg >= allExams.size()) return "Exam does not exist";
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
		String result = "";
		
		result += "Students\n";
		
		for(Student e : allStudents) {
			result += e.getName() + "\n";
		}
		
		result += "\nExams\n";
		
		for(Exam e : allExams) {
			result += e.getName() + "\n";
		}
		
		return result;
	}
	
}
