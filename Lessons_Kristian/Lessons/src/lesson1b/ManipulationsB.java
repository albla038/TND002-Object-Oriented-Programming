package lesson1b;

public class ManipulationsB {
	private static String species;
	private String name;
	
	public void setName(String arg) {name = arg;}
	public String getName() {return name;}
	
	public static void setSpecies(String arg) {species = arg;}
	public static String getSpecies() {return species;}
	
	public static void staticSwap(ManipulationsB arg1,ManipulationsB arg2) {
		String swap = arg1.getName();
		arg1.setName(arg2.getName());
		arg2.setName(swap);
	}
	
	public void instanceSwap(ManipulationsB arg) {
		String swap = name;
		name = arg.getName();
		arg.setName(swap);
	}
}
