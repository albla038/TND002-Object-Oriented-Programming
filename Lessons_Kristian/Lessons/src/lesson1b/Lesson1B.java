package lesson1b;

public class Lesson1B {

	public static void main(String[] args) {
		ManipulationsB human1 = new ManipulationsB(), human2 = new ManipulationsB();
		
		human1.setName("Paul");
		human2.setName("Astrid");

		System.out.println(human1.getName());
		System.out.println(human2.getName());
		
		ManipulationsB.setSpecies("Human");
		System.out.println(ManipulationsB.getSpecies());
		
		/*
		String swap = human1.getName();
		human1.setName(human2.getName());
		human2.setName(swap);
		
		System.out.println(human1.getName());
		System.out.println(human2.getName());
		
		ManipulationsB.staticSwap(human1,human2);
		
		System.out.println(human1.getName());
		System.out.println(human2.getName());
		
		human1.instanceSwap(human2);
		//Instance methods have access to global instance variables
		
		System.out.println(human1.getName());
		System.out.println(human2.getName());
		
		
		int days = 365;
		String text = String.format("One year has %3d days", days);
		System.out.println(text);
		
		double number = 654.321;
		text = String.format("The formatted number %7.3f is %7.3f", number, number);
		System.out.println(text);
		
		days = 365;
		String myText = "year";
		text = String.format("One %4s has %3d days", myText, days);
		System.out.println(text);
		
		
		String severalNames = "Paul Astrid,Thomas Sybill";
		
		String[] strArray = severalNames.split(",");
		System.out.println(strArray.length);
		System.out.println(strArray[0]);
		System.out.println(strArray[1]);
		//System.out.println(strArray[2]);
		
		
		ManipulationsB human3 = new ManipulationsB("Paul");
		ManipulationsB human4 = new ManipulationsB("Astrid");
		
		System.out.println(human3);
		
		ManipulationsB dog = new ManipulationsB("Barky", "Dog");
		*/
		
		String input = "Paul Anki Cesar   Miranda";
		
		String[] array = input.split(" +");
		
		System.out.println(array.length);
		
		ManipulationsB[] nameArray = new ManipulationsB[array.length];
		
		
		
		for(int i=0;i < array.length;i++) {
			nameArray[i] = new ManipulationsB(array[i]); System.out.println(nameArray[i] + " 1");
		}
		
		int i=0;
		while(i < array.length) {
			nameArray[i] = new ManipulationsB(array[i]); i++; System.out.println(nameArray[i] + " 2");
		}
		
		i=0;
		do {
			nameArray[i] = new ManipulationsB(array[i]); i++; System.out.println(nameArray[i] + " 3");
		} while(i < array.length);
		
	}

}
