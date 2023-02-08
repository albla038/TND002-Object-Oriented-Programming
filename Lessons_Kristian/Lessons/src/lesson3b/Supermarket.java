package lesson3b;
import java.util.ArrayList;

public class Supermarket {
	private ArrayList<Apple> soldApples;
	private ArrayList<Strawberry> soldStrawberries;
	private ArrayList<Fruit> availableFruit;
	
	public void addFruit(String arg1, String arg2, double arg3) {
		availableFruit.add(new Fruit(arg1,arg2,arg3));
	}
	
	public void stockUp(String arg1, String arg2, int arg3) {
		for (Fruit fruit : availableFruit) {
			if (fruit.isThisFruit(arg1, arg2)) {
				fruit.stockUp(arg3);
			}
		}
	}
	
	public void takeInventory() {
		
	}
	
	public void buyFruit(String arg1, String arg2, String arg3, int arg4) {
		
	}
	
	public String customerInfo(String arg) {
		String result = "";
		return result;
	}
}
