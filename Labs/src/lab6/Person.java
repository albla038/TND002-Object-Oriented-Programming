package lab6;

public class Person {
	
	private String givenName;
	private String surname;
	private int phoneNumber;
	
	public Person(String name, String lastName, int number) {
		givenName = name;
		surname = lastName;
		phoneNumber = number;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getFullName() {
		return givenName + " " + surname; //?? Method or private variable, which is preffered?
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
}
