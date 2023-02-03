package lesson3a;

import java.util.*;

public class TVSet extends Product {

	private static final String NAME = "tv set";
	private String brand;
	private int price;
	private String description;
	public static ArrayList<TVSet> allTVs = new ArrayList<TVSet>();
	private static Random rnd = new Random();
	
	public TVSet(String brand) {
		super(NAME);
		this.brand = brand;
		price = fetchRandomNum(5000, 10001);
		//price = (int) Math.random() * 5000 + 10002;
		allTVs.add(this);
	}
	
	public TVSet(String brand, Double score) {
		super(NAME, score);
		this.brand = brand;
		price = fetchRandomNum(5000, 10001);
		allTVs.add(this);
	}
	
	private static int fetchRandomNum(int arg, int arg2) {
		return rnd.nextInt(arg) + arg2;
	}
	
	public String toString() {
		return super.toString() + "Hello from TV Set";
	}
}
