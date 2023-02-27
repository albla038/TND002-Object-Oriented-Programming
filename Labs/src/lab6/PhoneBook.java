package lab6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PhoneBook {
	private ArrayList<Person> listOfNumbers;
	
	public PhoneBook() {
		listOfNumbers = new ArrayList<Person>(); //?? Why isn't this initialized in the class
	}
	
	public String load(String fileName) {
		String result;
		
		File file = new File(fileName);
		if (!file.exists()) {
			return "Try again. File not found";
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null) {
				String[] personInfo = line.split(" +");
				listOfNumbers.add(new Person(personInfo[0], personInfo[1], Integer.valueOf(personInfo[2])));
			}
			br.close();
			result = "Phone book loaded";
		}
		catch(IOException ioException){
			result = "Try again";
		}
		
		return result;
	}
	
	public ArrayList<Person> search(String searchKey){
		int number;
		try {
			number = Integer.parseInt(searchKey);
		}
		catch (NumberFormatException e) {
			number = -1;
		}
		ArrayList<Person> result = new ArrayList<Person>();
		
		if (number != -1) { //searchKey is a phone number
			for (Person p : listOfNumbers) {
				if (p.getPhoneNumber() == number) {
					result.add(p);
				}
			}
		} else {
			for(Person p : listOfNumbers) {
				if (p.getSurname().equals(searchKey)){
					result.add(p);
				}
			}
		}
		
		if (result.isEmpty()) {
			System.out.println("Warning. Return list is empty!");
		}
		
		return result;
	}
	
	public String deletePerson(String fullName, int number) {
		String result = "The person/number does not exist";
		String searchNumber = String.valueOf(number);
		
		ArrayList<Person> matchingNumberList = search(searchNumber); // Get persons with the input number arg
		for (Person p : matchingNumberList) {
			if (fullName.equals(p.getFullName())) { 				 // Get fullName of person and compare it to the input name arg.
				listOfNumbers.remove(p);			  				 // If matching fullName found, remove from list
				result = "Person deleted";
			}
		}
		return result;
	}
	
	public boolean addPerson(String fullName,int number) {
		Boolean result = false;
		String[] name = fullName.split(" +");
		if(name.length == 2 && search(String.valueOf(number)).size() == 0) { //Two words in Full name and no elements containing number
			listOfNumbers.add(new Person(name[0],name[1],number));
			result = true;
		}
		return result;
	}
	
	public String save(String fileName) {
		String result;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));
			for (Person p : listOfNumbers) {
				bw.write(String.format("%20s %5d\n",p.getFullName(),p.getPhoneNumber()));
			}
			bw.close();
			result = "Saved " + listOfNumbers.size() + " people to the file.";
		}
		catch (IOException e){
			result = "Could not save to the file";
		}
		return result;
	}
	
	public void printArray() {
		for (Person p : listOfNumbers) {
			System.out.print(p.getFullName() + " " + p.getPhoneNumber() + "\n");
		}
	}
	
}
