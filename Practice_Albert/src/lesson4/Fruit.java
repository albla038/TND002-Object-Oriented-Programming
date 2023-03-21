package lesson4;

public class Fruit {

	private String specifics;
	private double price;
	
	public Fruit(String arg1, double arg2) {
		specifics = arg1;
		price = arg2;
	}
	
	public String computeCost(int arg) {
		return "Fruit" + arg * price;
	}
	
	public String toString() {
		return String.format("Specifics: %7s, Price: %8.2", specifics, price);
	}
	
	public static class Strawberry {
		private String name, specifics;
		private double price;
		
		public Strawberry(String arg1, String arg2, double arg3) {
			name = arg1;
			specifics = arg2;
			price = arg3;
		}
		
		public String computeCost(int arg) {
			return "Strawberry" + arg * price;
		}
		
		public String toString() {
			return new Fruit(specifics, price).toString();
		}
	}
}
