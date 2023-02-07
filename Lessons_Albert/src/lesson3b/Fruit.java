package lesson3b;

public class Fruit {

	protected final String NAME, SPECIFICS;
	protected final double PRICE;
	private int amount;
	
	public Fruit(Fruit arg) {
		NAME = arg.NAME;
		SPECIFICS = arg.SPECIFICS;
		PRICE = arg.PRICE;
	}
	
	public Fruit(String name, String specifics, double price) {
		NAME = name;
		SPECIFICS = specifics;
		PRICE = price;
		amount = 0;
	}
	
	public int getAmount() {
		return amount;
	}
	
	// returns NAME and SPECIFICS in a array with two elements
	public String[] getInfo() {
		return new String[] {NAME, SPECIFICS};
	}
	
	public void stockUp(int arg) {
		amount += arg;
	}
	
	public boolean isThisFruit(String arg1, String arg2) {
		if (NAME.equals(arg1) && SPECIFICS.equals(arg2)) { //.equals compares the contents of the string instances.
			return true;
		}
		return false;
	}
	
	public int getFruit(int arg) {
		if (arg <= amount) {
			amount -= arg;
		} else {
			arg = amount;
			amount = 0;
		}
		return arg;
	}
	
	public String theName() {
		String arg;
		
		if (this instanceof Apple) {
			arg = "Apple";
		} else if (this instanceof Strawberry) {
			arg = "Apple";
		} else {
			arg = "Fruit";
		}
		return arg;
	}
	
	public String toString() {
		return String.format("Name: %8s Specifics: %8s, Price: %5.2f, Amount: %3d",
				NAME, SPECIFICS, PRICE, amount);
	}
}