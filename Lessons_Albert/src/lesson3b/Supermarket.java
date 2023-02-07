package lesson3b;

import java.util.ArrayList;

public class Supermarket {
	private ArrayList<Apple> soldApples = new ArrayList<Apple>();
	private ArrayList<Strawberry> soldStrawberries = new ArrayList<Strawberry>();;
	private ArrayList<Fruit> availableFruit = new ArrayList<Fruit>();
	
	public void addFruit(String name, String specifics, double price) {
		availableFruit.add(new Fruit(name, specifics, price));
	}
	
	public void stockUp(String name, String specifics, int amount) {
		for (Fruit e : availableFruit) {
			if (e.isThisFruit(name, specifics)) {
				e.stockUp(amount);
			}
		}
	}
	
	public void takeInventory() {
		/*
		int availableApples = 0;
		int availableStrawberries = 0;
		
		for (Fruit e : availableFruit) {
			if (e.isThisFruit(null, null))
		}
		*/
		
		String.format("Available apples %", availableApples, )
		System.out.println();
	}
}
