package lesson4;

public class Fruit {
	private String specifics;
	private double price;
	private Fruit outerClass;
	
	public Fruit(String arg1, double arg2) {
		specifics = arg1; price = arg2; outerClass = this;
	}
	
	public String computeCost(int arg) {
		return "Fruit: " + (arg * price);
	}
	
	public String toString() {
		return String.format("Specifics: %7s, Price: %5.2f", specifics, price);
	}
	
	public static class Strawberry {
		private String name, specifics;
		private double price;
		
		public Strawberry(String arg1, String arg2, double arg3) {
			name = arg1; specifics = arg2; price = arg3;
		}
		
		public String computeCost(int arg) {
			return "Strawberry: " + (arg * price);
		}
		
		public String toString() {
			return new Fruit(specifics, price).toString();
		}
	}
	
	public class Apple {
		private String name;
		
		public Apple(String arg) {
			name = arg;
		}
		
		public String toString() {
			return String.format("Name:%7s, Specifics:%7s, Price:%5.2f", name, specifics, price) + " (outer class call) " + outerClass.toString();
		}
	}
	
	public class Banana {
		private String name, specifics;
		private double price;
		
		public Banana(String arg1, String arg2, double arg3) {
			name = arg1; specifics = arg2; price = arg3;
		}
		
		public String diagnostics() {
			return "Diagnostics: " + name + " " + specifics + " " + price;
		}
	}
}
