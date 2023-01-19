package lesson1a;

public class ManipulationsA {
	
	public static boolean returnAnInt = true;
	private static double value = 4.0;
	
	public static void convert() {
		double out = value;
				
		if (returnAnInt) {
			out = convert(value);
		}
		
		System.out.println(out);
	}
	
	public static double convert(int arg) {
		return (double) arg;
	}
	
	public static int convert(double arg) {
		return (int) arg;
	}
}
