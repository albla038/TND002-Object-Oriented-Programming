package lesson4;

public class Fruit {
	
	private String specifics;
	private double price;
	
	public Fruit(String specifics, double price) {
		this.specifics = specifics;
		this.price = price;
	}
	
	public String computeCost(int amount) {
		return "Fruit: " + amount * price;
	}
	
	public String toString() {
		return String.format("Specifics: %7s, Price: %5.2f", specifics, price);
	}
	
	public class Apple {
		private String name;
		
		public Apple(String name) {
			this.name = name;
		}
		
		public String toString() {
			Fruit outerClassFruit = new Fruit(name, price);
			
			return String.format("Name: %7s Specifics: %7s, Price: %5.2f (outer class call) " + outerClassFruit.toString(),
					name, specifics, price);
		}
	}
	
	public class Banana {
		
	}
	
	public static class Strawberry {
		private String name, specifics;
		private double price;
		
		public Strawberry(String name, String specifics, double price) {
			this.name = name;
			this.specifics = specifics;
			this.price = price;
		}
		
		public String computeCost(int amount) {
			return "Strawberry: " + amount * price;
		}
		
		public String toString() {
			return new Fruit(specifics, price).toString();
		}
	}
}
