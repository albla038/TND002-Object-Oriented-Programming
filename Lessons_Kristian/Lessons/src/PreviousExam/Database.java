package PreviousExam;

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
	//Pressing enter on console flushes buffer of input reader
	public void addStudent(String arg1, String arg2) {
		allStudents.add(new Student(arg1, arg2));
	}
	
	public String loadStudents(String arg1, int arg2) {
		String result = "";
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(arg1));
			result = String.format("Loaded %2d students", arg2);
			for(int i = 0; i < arg2; i++) {
				String[] temp = fileReader.readLine().split(" +");
				addStudent(temp[0], temp[1]);
			}
			fileReader.close();
		} catch(IOException e){
			result = "Something went wrong";
		}
		return result;
	}
	
	public String addExam(String arg1, int arg2) {
		try {
			while(true) {
				try {
					System.out.print("Maximum points possible: ");
					int arg4 = Integer.parseInt(consoleReader.readLine());
					System.out.print("Minimum points possible: ");
					int arg3 = Integer.parseInt(consoleReader.readLine());
					allExams.add(new Exam(arg1, arg2, arg3, arg4));
					return "Course: " + arg1 + " added";
				} catch(NumberFormatException i) {
					;
				}
			}
		}catch(IOException e) {
			return "Something went wrong (IOExcpetion)";
		}
	}
	
	public String checkStudent(int arg) {
		if(arg < allStudents.size()) {
			return allStudents.get(arg).toString();
		} else {
			return "Student does not exist";
		}
	}
	
	public String checkExam(int arg) {
		if(arg < allExams.size()) {
			return allExams.get(arg).toString();
		} else {
			return "Exam does not exist";
		}
	}
	
	public String markStudent(String arg1, int arg2, int arg3) {
		Student tempStudent = null;
		Exam tempExam = null;
		
		for(Student s : allStudents) {
			if(s.getName().equals(arg1)) {
				tempStudent = s;
			}
		}
		
		for(Exam e : allExams) {
			if(e.getCode() == arg2) {
				tempExam = e;
			}
		}
		
		//System.out.println(tempStudent);
		//System.out.println(tempExam);
		//System.out.println(tempExam.getMaxPoints());
		
		if(tempStudent != null && tempExam != null && tempExam.getMaxPoints() > arg3){
			String arg4 = "";
			//System.out.println("Test line");
			if (tempExam.getMinPoints() <= arg3) {
				arg4 = "G";
			} else {
				arg4 = "U";
			}
			
			MarkingSheet tempSheet = new MarkingSheet(arg2, tempExam, tempStudent);
			
			tempSheet.setGrade(arg4);
			
			tempExam.addMarkedStudent(tempSheet);
			tempStudent.addMarkingSheet(tempSheet);
			
			return String.format("Student %10s got the grade %1s", arg1, arg4);
		} else {
			return "Could not create marking sheet";
		}
	}
	
	public String toString() {
		String result = "Students\n";
		
		for(Student s : allStudents) {
			result += s.getName() + "\n";
		}
		
		result += "\nExams\n";
		
		for(Exam e : allExams) {
			result += e.getName() + "\n";
		}
		
		return result;
	}
}
