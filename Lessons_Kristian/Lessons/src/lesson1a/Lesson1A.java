package lesson1a;

public class Lesson1A {
	
	public static void main(String[] args) {
		System.out.println("Lesson 1A\n—————————"); 
		double d1 = 4.0;
		System.out.println("The double value is " + d1);
		int i1 = 10;
		System.out.println("The sum of the double value and the integer value is " + (d1 + i1));
		System.out.println(d1 + i1 + " is the sum of the double value and the integer value.");
		int i2 =(int) d1;
		System.out.println("Result of the cast is: " + i2);
		boolean b1 = true;
		System.out.println(b1);
		final double d2 = 2.0;
		final double d3;
		d3 = 5.0;
		System.out.println(d3);
		
		System.out.println(Manipulations.convert(1));
		
		System.out.println(Manipulations.convert(4.0));
		
		Manipulations manip = new Manipulations();
		
		System.out.println(manip);
		
		Manipulations.convert();
	}
	
}
