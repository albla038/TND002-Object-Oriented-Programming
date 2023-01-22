package lesson1b;

public class Lesson1B {

	public static void main(String[] args) {
		
		ManipulationsB.setSpecies("Human");
		System.out.println(ManipulationsB.getSpecies());
		
		ManipulationsB human1 = new ManipulationsB();
		human1.setName("Paul");
		
		ManipulationsB human2 = new ManipulationsB();
		human2.setName("Astrid");
		
		System.out.println(ManipulationsB.getSpecies() + " - " + human1.getName());
		System.out.println(ManipulationsB.getSpecies() + " - " + human2.getName());
	
		/*
		String temp = human1.getName();
		human1.setName(human2.getName());
		human2.setName(temp);
		*/
		
		ManipulationsB.staticSwap(human1, human2);
		
		System.out.println("-----");
		
		System.out.println(ManipulationsB.getSpecies() + " - " + human1.getName());
		System.out.println(ManipulationsB.getSpecies() + " - " + human2.getName());
		
		human1.instanceSwap(human2);

		System.out.println("-----");
		
		System.out.println(ManipulationsB.getSpecies() + " - " + human1.getName());
		System.out.println(ManipulationsB.getSpecies() + " - " + human2.getName());
		
		int days = 365;
		double number = 654.321;
		String text = String.format("One year has %1d days", days);
		System.out.println("\n"+ text);
		
		text = String.format("The formatted number %7.3f is %1.1f", number, number);
		System.out.println("\n"+ text);
		
		String myText = "year";
		text = String.format("One %4s has %1d days", myText, days);
		System.out.println("\n"+ text);
		
		String severalNames = "Paul Astrid,Thomas Sybill";
		String[] strarray = severalNames.split(",");
		System.out.println(strarray.length);
		
		human1 = new ManipulationsB("Paul");
		human1 = new ManipulationsB("Astrid");
		
		System.out.println(human1);
		
		ManipulationsB dog = new ManipulationsB("Barky", "Dog");
	
		System.out.println(dog);
		System.out.println(human1);
		
		String input = "Paul Anki Cesar Miranda";
		String[] nameArray = input.split(" ");
		ManipulationsB[] people = new ManipulationsB[nameArray.length];
	
		System.out.println("\n\n----");
		
		for (int i = 0; i < nameArray.length; i++) {
			people[i] = new ManipulationsB(nameArray[i]);
			System.out.println(people[i]);
		}
	}

}
