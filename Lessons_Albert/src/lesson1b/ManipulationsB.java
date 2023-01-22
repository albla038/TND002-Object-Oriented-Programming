package lesson1b;

public class ManipulationsB {
	
	private static String species;
	
	private String name;
	
	public ManipulationsB() {
		name = "";
		species = "Human";
		System.out.print("Default constructor was called " + name + species + "\n");
	}
	
	public ManipulationsB(String arg) {
		name = arg;
		species = "Human";
		System.out.print("Default constructor was called " + name + species + "\n");
	}
	
	public ManipulationsB(String arg1, String arg2) {
		name = arg1;
		species = arg2;
		System.out.print("Default constructor was called " + name + species + "\n");
	}
	
	public static void staticSwap(ManipulationsB arg1, ManipulationsB arg2) {
		String temp = arg1.getName();
		arg1.setName(arg2.getName());
		arg2.setName(temp);
	}
	
	public static void setSpecies(String arg) {
		species = arg;
	}
	
	public static String getSpecies() {
		return species;
	}
	
	public void instanceSwap(ManipulationsB arg) {
		String temp = getName();
		setName(arg.getName());
		arg.setName(temp);
	}
	
	public void setName(String arg) {
		name = arg;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		String result = String.format("Species: %-10s, Name: %10s", species, name);
		return result;
	}

}
