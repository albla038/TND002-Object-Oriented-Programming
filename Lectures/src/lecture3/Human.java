package lecture3;

public class Human {
	
	private String name;
	
	public Human() {
		name = "Mark"; //Does not have a return type. Constructors always returns adresses
	}
	
	public Human(String arg) {
		name = arg;
	}
	
	public void setName(String arg) {
		name = arg;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "The name is: " + name;
	}
}
