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
}
