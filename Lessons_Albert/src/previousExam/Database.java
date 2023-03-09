package previousExam;

import java.io.*;
import java.util.ArrayList;

public class Database {
	private ArrayList<Student> allStudents;
	private ArrayList<Exam> allExams;
	private BufferedReader consoleReader;
	
	public Database() {
		allStudents = new ArrayList<Student>();
		allExams = new ArrayList<Exam>();
		consoleReader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void addStudent(String inFirstName, String inLastName) {
		allStudents.add(new Student(inFirstName, inLastName)); // Create anonymous instance and add to list
	}
	
	public String loadStudents(String fileName, int numOfStudents) {
		String result;
		String line;
		int counter = 0;
		
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(new File(fileName)));
			for (int i = 0; ((line = fileReader.readLine()) != null) && (i < numOfStudents); i++) {
				String[] lineToken = line.split(" +");
				addStudent(lineToken[0], lineToken[1]);
				counter++;
			}
			fileReader.close();
			result = String.format("Loaded %2d students", counter);
		} catch (IOException e) {
			result = "Something went wrong (IOException)";
		}
		return result;
	}
	
	public String addExam(String inName, int inCode) {
		int maxPoints;
		int minPoints;
		String result;
		
		try {
			System.out.print("Maximum points possible: ");
			maxPoints = Integer.parseInt(consoleReader.readLine());
			System.out.print("Minimum points possible: ");
			minPoints = Integer.parseInt(consoleReader.readLine());
			allExams.add(new Exam(inName, inCode, minPoints, maxPoints));
			result = "Course: " + inName + " added";
		} catch (IOException e) {
			e.printStackTrace();
			result = "Something went wrong (IOException)";
		} catch (NumberFormatException e) {
			addExam(inName, inCode);
			result = "Something went wrong (NumberFormatException). Try again";
		}
		return result;
	}
	
	public String checkStudent(int index) {
		if (index < allStudents.size()) {
			return allStudents.get(index).toString();
		} else {
			return "Student does not exist";
		}
	}
	
	public String checkExam(int index) {
		if (index < allExams.size()) {
			return allExams.get(index).toString();
		} else {
			return "Exam does not exist";
		}
	}
	
	public String markStudent(String surname, int courseCode, int points) {
		String result = "Could not create marking sheet";
		
		for (Exam e : allExams) {
			if (e.getCode() == courseCode && e.getMaxPoints() >= points ) {
				for (Student s : allStudents) {
					if (s.getName().equals(surname)) {
						String grade = "U";
						if (points >= e.getMinPoints()) grade = "G";
						
						MarkingSheet tempSheet = new MarkingSheet(courseCode, e, s);
						tempSheet.setGrade(grade);
						e.addMarkedStudent(tempSheet);
						s.addMarkingSheet(tempSheet);
						result = String.format("Student %10s got the grade %1s", surname, grade);
					}
				}
			}
		}
		
		return result;
	}
	
	public String toString() {
		String result = "Students\n";
		for (Student s : allStudents) {
			result += s.getName() + "\n";
		}
		result += "\nExams\n";
		for (Exam e : allExams) {
			result += e.getName() + "\n";
		}
		return result;
	}
}