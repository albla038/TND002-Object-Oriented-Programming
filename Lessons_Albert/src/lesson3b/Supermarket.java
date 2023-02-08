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
		for (Fruit fruit : availableFruit) {
			String[] fruitInfo = fruit.getInfo();
			int inStore = fruit.getAmount();
			int bought = 0;
			
			if (fruitInfo[0].equals("Apple")) {
				for (Apple apple : soldApples) {
					if (apple.isThisFruit(fruitInfo[0], fruitInfo[1])) {
						bought += apple.getAmount();
					}
				}
				System.out.println(String.format("Available apples (%6s): %3d, Sold apples: %3d", fruitInfo[1], inStore, bought));
			}
			else if (fruitInfo[0].equals("Strawberry")) {
				for (Strawberry strawberry : soldStrawberries) {
					if (strawberry.isThisFruit(fruitInfo[0], fruitInfo[1])) {
						bought += strawberry.getAmount();
					}
				}
				System.out.println(String.format("Available strawberries (%6s): %3d, Sold: %3d", fruitInfo[1], inStore, bought))
			}			
		}
	}
}
