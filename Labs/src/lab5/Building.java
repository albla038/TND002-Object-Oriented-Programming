package lab5;

public abstract class Building implements Comparable<Building> {
	
	private String adress;
	private double price;
	protected int squareMeters;
	protected static int selection = 1;
	
	public Building(String inAdress, double inPrice, int inSquareMeters) {
		adress = inAdress;
		price = inPrice;
		squareMeters = inSquareMeters;
	}
	
	public abstract double maintenance();
	
	public int compareTo(Building arg) {
		
		int result;
		
		if (selection == 1) {
			if (price == arg.price) {
				result = 0;
			} else if (price < arg.price) {
				result = -1;
			} else result = 1;
		} else {
			if (squareMeters == arg.squareMeters) {
				result = 0;
			} else if (squareMeters < arg.squareMeters) {
				result = -1;
			} else result = 1;
		}
		
		return result;
	}
	
	public String toString() {
		String result = String.format("Adress: %16s, Living area: %4d, Price: %10.2f, Maintenance (per month): %7.2f",
				adress, squareMeters, price, maintenance());
		
		if (this instanceof CityProperty) {
			CityProperty temp = (CityProperty) this;
			result += ", Property tax: " + temp.computePropertyTax();
		} else {
			result += "\n";
		}
		
		return "\n" + result;
	}
}
