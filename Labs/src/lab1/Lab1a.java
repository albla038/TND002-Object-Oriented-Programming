package lab1;

public class Lab1a {
	
	public static void main(String[] args) {
		
		double[] da1 = {1.0, 2.0, 3.0}, da2 = {0.0, -0.5, -2.0};
		
		double[] da3 = addition(da1, da2);
		double[] da4 = subtract(da1, da2);
		
		printVector(da4);
	}
	
	public static double[] addition(double[] arg1, double[] arg2) {
		
		double[] result = {arg1[0] + arg2[0],
				arg1[1] + arg2[1],
				arg1[2] + arg2[2]};
		
		return result;
	}
	
	public static double[] subtract(double[] arg1, double[] arg2) {
		
		double[] result = {arg1[0] - arg2[0],
				arg1[1] - arg2[1],
				arg1[2] - arg2[2]};
		
		return result;
	}
	
	public static void printVector(double[] arg) {
		if(arg.length == 3) {
			System.out.println(String.format("Vector = (%4.1f, %4.1f, %4.1f)", arg[0], arg[1], arg[2]));
		}
		
	}
	
}
