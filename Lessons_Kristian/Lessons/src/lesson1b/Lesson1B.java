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
	}

}
