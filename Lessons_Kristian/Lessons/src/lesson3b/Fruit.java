package lesson3b;

public class Fruit {
	protected final String NAME, SPECIFICS;
	protected final double PRICE;
	private int amount;
	
	public Fruit(Fruit arg) { //object can only be created if all variables are initialized
		NAME = arg.NAME;
		SPECIFICS = arg.SPECIFICS;
		PRICE = arg.PRICE;
	}
	
	public Fruit(String arg1, String arg2, Double arg3) {
		NAME = arg1;
		SPECIFICS = arg2;
		PRICE = arg3;
		amount = 0;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String[] getInfo() {
		String[] result = new String[] {NAME,SPECIFICS};
		return result;
		
		//String[] temp = new String[];
		//temp[0] = NAME; temp[1] = SPECIFICS;
		//return temp;
	}
	
	public void stockUp(int arg) {
		amount += arg;
		//amount = amount + arg;
	}
	
	public boolean isThisFruit(String arg1, String arg2) {
		if (NAME.equals(arg1) && SPECIFICS.equals(arg2)) { //compare content of two strings, not address
			return true;
		} else {
			return false;
		}
		// if (NAME.equals(arg1) && SPECIFICS.equals(arg2)) return true;
		// return false;
		//shortened version
		
		//have one return statement with a variable, change variable in the method
	}
	
	public int getFruit(int arg) {
		if (arg <= amount) {
			amount -= arg;
			//amount = amount - arg;
			return arg;
		} else {
			//arg = amount; amount = 0;
			int temp = amount;
			amount = 0;
			return temp;
		}
		//return arg;
	}
	
	public String theName() {
		if (this instanceof Strawberry) { //access object that code is within with "this"
			return "Strawberry";
		} else if (this instanceof Apple) {
			return "Apple";
		} else {
			return "Fruit";
		}
	}
	
	public String toString() {
		return String.format("Name: %8s Specifics: %8s , Price: %5.2f , Amount: %3d", NAME, SPECIFICS, PRICE, amount);
	}
}
