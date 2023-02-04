package lesson3a;

import java.util.ArrayList;

public class Product {
	public final String NAME;
	public static final String[] ALLSTORES = {"Norrköping", "Linköping", "Stockholm", "Malmö"};
	private Double userScore = null;
	private /**/static ArrayList<String> availableStores;
	public String description;
	private /**/static ArrayList<String> stores = new ArrayList<String>(); //must be initialized?
	
	public Product(String arg) {
		NAME = arg;
		convertArray();
	}
	public Product(String arg1, Double arg2) {
		NAME = arg1; userScore = arg2;
		convertArray();
	}
	
	private void convertArray() {
		//availableStores = new ArrayList<String>();
		//for (int i = 0; i < ALLSTORES.length; i++;){
		//	availableStores.add(ALLSTORES[i]);
		//}
		availableStores = new ArrayList<String>();
		for(String store : ALLSTORES) {
		availableStores.add(store);
		}
	}
	
	public static String listAvailableStores(){
		String result = "Number, City\n";
		
		//for (int i=0; i < availableStores.size(); i++) {
		//	result = result + i + " " + availableStores.get(i);
		//}
		
		for(String store : availableStores) {
			result += availableStores.indexOf(store) + " " + store + "\n";
		}
		
		return result;
	}
	
	public static String selectStore(int arg) {
		
		//if (arg < availableStores.size()) {
		//	String temp = availableStores.get(arg);
		//	stores.add(temp);
		//	availableStores.remove(arg);
		//	return temp + "added";
		//}
		
		if(arg < availableStores.size() && arg >= 0) {
			//stores.add(availableStores.remove(arg)); //Can't display removed store
			String temp = availableStores.get(arg);
			stores.add(temp);
			availableStores.remove(arg);
			return temp + " added";
		} else {
			return "Wrong number";
		}
	}
	
	public String setDescription(String arg) {
		description = arg;
		return "Product description done";
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getRating() {
		if (userScore == null) {
			return "Not rated yet";
		} else {
			return userScore.toString();
		}
	}
	
	public String toString() {
		String result = "This product ";
		if (userScore != null) {
			result += "has the user score " + userScore + " and ";
		}
		result += "is available in the shops in: ";
		for(int i = 0; i < stores.size(); i++) {
			result += stores.get(i);
			if (i == stores.size() - 2) {
				result += " and ";
			} else if (i == stores.size() - 1){
				result += ".";
			} else {
				result += ", ";
			}
		}
		return result;
	}
}
