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
				String[] lineToken = line.split("+ ");
				addStudent(lineToken[0], lineToken[1]);
				counter++;
			}
			consoleReader.close();
			result = String.format("Loaded %2d students", counter);
		} catch (IOException e) {
			result = "Something went wrong";
		}
		return fileName;
	}
	
	public String addExam(String inName, int inCode) {
		int maxPoints;
		int minPoints;
		String result;
		
		try {
			System.out.print("Maximum points possible: ");
			maxPoints = Integer.valueOf(consoleReader.readLine());
			System.out.print("Minimum points possible: ");
			minPoints = Integer.valueOf(consoleReader.readLine());
			// Create object
		} catch (IOException e) {
			result = "Something went wrong";
		} catch (NumberFormatException e) {
			addExam(inName, inCode);
		}
	}
}
