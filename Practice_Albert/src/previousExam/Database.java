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
		allStudents.add(new Student(inFirstName, inLastName));
	}
	
	public String loadStudents(String fileName, int numOfStudents) {
		
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(new File(fileName)));
			
			String line = "";
			int counter = 0;
			for (int i = 0; ((line = fileReader.readLine()) != null) && (i < numOfStudents); i++) {
				String[] lineSplit = line.split(" +");
				addStudent(lineSplit[0], lineSplit[1]);
				counter++;
			}
			
			fileReader.close();
			return String.format("Loaded %2d students", counter);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "Could not find file";
		} catch (Exception e) {
			return "Something went wrong";
		}
	}
	
	public String addExam(String name, int code) {
		
		try {			
			System.out.print("Maximum points possible: ");
			int maxPoints = Integer.parseInt(consoleReader.readLine());
			System.out.print("Minimum points possible: ");
			int minPoints = Integer.parseInt(consoleReader.readLine());
			allExams.add(new Exam(name, code, minPoints, maxPoints));
			return "Course: " + name + " added";
		} catch (IOException e) {
			System.out.println("Could not read from console. Try again!");
			addExam(name, code);
		} catch (NumberFormatException e) {
			System.out.println("Could not read input. Try again!");
			addExam(name, code);
		}
		
		return "Could not add exam";
		
	}
	
	public String checkStudent(int index) {
		for (Student s : allStudents) {
			if (allStudents.indexOf(s) == index) {
				return s.toString();
			}
		}
		
		return "Student does not exist";
	}
	
	public String checkExam(int index) {
		for (Exam e : allExams) {
			if (allExams.indexOf(e) == index) {
				return e.toString();
			}
		}
		
		return "Exam does not exist";
	}
	
	public String markStudent(String name, int code, int points) {
		for (Exam e : allExams) {
			if ((e.getCode() == code) && (points <= e.getMaxPoints())) {
				for (Student s : allStudents) {
					if (s.getName().equals(name)) {
						
						String grade = "G";
						if (points < e.getMinPoints()) grade = "U";
						
						MarkingSheet markingSheet = new MarkingSheet(code, e, s);
						markingSheet.setGrade(grade);
						e.addMarkedStudent(markingSheet);
						s.addMarkingSheet(markingSheet);
						
						return String.format("Student %10s got the grade %1s", s.getName(), grade);
					}
				}
			}
		}
		return "Could not create marking sheet";
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
