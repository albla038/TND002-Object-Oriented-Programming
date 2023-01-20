package lesson1a;

public class ManipulationsA {
	//variables at the top, even before constructors
	public static boolean returnAnInt = true;
	private static double value = 4.0;
	
	public static double convert(int arg){return (double) arg;}
	
	public static int convert(double arg){return (int) arg;}
	
	public static void convert(){
		if(returnAnInt)System.out.println(convert(value));
		else System.out.println(value);
		}
	//boolean in if statement doesn't need to be compared, already true or false
	//returns void > can't be put into System.out.println()
}
