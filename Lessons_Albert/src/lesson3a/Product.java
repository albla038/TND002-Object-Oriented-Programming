package lesson3a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Product {
	
	public final String NAME;
	public static final String[] ALLSTORES = {"Norrköping", "Linköping", "Stockholm", "Malmö"};
	private Double userScore = null;
	private static ArrayList<String> availableStores;
	public String description;
	private static ArrayList<String> stores;
	
	public Product(String name) {
		NAME = name;
		convertArray();
	}
	
	public Product(String name, Double score) {
		NAME = name;
		userScore = score;
		convertArray();
	}
	
	private void convertArray() {
		availableStores = new ArrayList<String>();
		
//		for (String e : ALLSTORES) {
//			availableStores.add(e);
//		}
		
		Collections.addAll(availableStores, ALLSTORES);
	}
	
	public String listAvailableStores() {
		String result = "Number, City\n";
		for (String store : availableStores) {
			result += store + " " + availableStores.indexOf(store) + "\n";
		}
		return result;
	}
	
	public static String selectStore(int arg) {
		if (arg < 0 || arg < availableStores.size()) {
			return "Wrong number";
		}
		
		String temp = availableStores.remove(arg);
		stores.add(temp);
		return "Store in " + temp + " selected";
	}
	
	public String setDescription(String desc) {
		description = desc;
		return "Product description done";
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getRating() {
		if (userScore != null) {
			return String.format("%1.1f", userScore);
		} else {
			return "Not yet rated";
		}
	}
	
	public String toString() {
		String result = "This product ";
		if (userScore != null) {
			result += "has the user score " + getRating() + " and is available in the shops in:\n";
		} else {
			result += "is available in the shops in:\n";
		}
		
		for (String store : stores) {
			result += store + ", ";
		}
		
		return result;
		
	}
}
