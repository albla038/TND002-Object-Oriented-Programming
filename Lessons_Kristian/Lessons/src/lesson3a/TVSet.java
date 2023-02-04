package lesson3a;

import java.util.ArrayList;
import java.util.Random;

public class TVSet extends Product{
	private String brand, description;
	private int price;
	public static ArrayList<TVSet> allTVs = new ArrayList<TVSet>();
	
	//needs default constructor in superclass with no args
	//in order to use default constructor in subclass
	
	public TVSet(String arg) {
		super("tv set"); //calls superclass constructor with arg "tv set", must be first line
		brand = arg;
		Random rand = new Random();
		price = 10000 + rand.nextInt(5001);
		allTVs.add(this); //adds created object to allTVs
	}
	
	public TVSet(String arg1, Double arg2) {
		super("tv set", arg2);
		brand = arg1;
		Random rand = new Random();
		price = 10001 + rand.nextInt(5000);
		allTVs.add(this);
	}
	
	public String setDescription(String arg) {
		String temp[] = arg.split(",");
		description = temp[1].trim();;
		
		return super.setDescription(temp[0].trim());
	}
	
	public String getDescription() {
		return "TV description: " + description + "\nProduct information: " + super.description;
	}
	
	public static void listTVs() {
		for (TVSet tvInfo : allTVs) {
			String result = tvInfo.brand + " " + tvInfo.price + " " + tvInfo.getRating();
			System.out.println(result);
		}
	}
	
	public String toString() {
		String result = "The " + NAME + " is manuafactured by " + brand + " and costs " + price + "SEK\n";
		
		return result + super.toString();
	}
	
	//public String toString(){
	//	return super.toString() + "TVSet";
	//}
	
	//super taking the place of super, used to reference superclass
}