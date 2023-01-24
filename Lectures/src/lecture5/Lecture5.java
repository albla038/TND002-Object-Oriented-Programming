package lecture5;
import java.util.Random;
import java.util.ArrayList;

public class Lecture5 {

	public static void main(String[] args) {
		
		Random r = new Random();
		//System.out.println(r.nextDouble());
		
		Double[] rArray = new Double[3];
		rArray[0] = 1.0; rArray[1] = 2.0; rArray[2] = 7.0;
		
		Integer[] oneDArray = {1, 2};
		int[][] twoDArray = {{1, 2}, {5, 3}};
		
		//System.out.println(twoDArray[0][1]);
		
		ArrayList<Double> aL = new ArrayList<Double>();
		
		Generics<Double> g1 = new Generics<Double>(1.2);
		System.out.println(g1);
		
		Generics<Integer> g2 = new Generics<Integer>(1);
	}
}
