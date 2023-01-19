package lecture3;

public class Human {
	
	private String name;
	private static String defaultName = "Karl";
	
	public Human() {
		name = "Mark"; //Does not have a return type. Constructors always returns adresses
	}
	
	public Human(String arg1) {
		name = arg1;
	}
	
	public void setName(String arg) {
		name = arg;
	}
	
	public String getName() {
		return name;
	}
	
	public void setToDefault() {
		name = defaultName;
	}
	
	public static void changeDefault(String arg) {
		defaultName = arg;
	}
	
	
	public String toString() {
		return "Name: " + name;
	}
}
