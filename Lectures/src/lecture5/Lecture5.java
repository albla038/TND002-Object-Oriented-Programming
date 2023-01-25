package lecture5;
import java.util.Random;
import java.util.ArrayList;

public class Lecture5 {

	public static void main(String[] args) {
		
		/*
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
		*/
		
		ArrayList<Double> dAL = new ArrayList<Double>();
		
		Double d1 = 1.0, d2 = 2.0, d3 = 3.0, d4 = 4.0, d5 = 5.0;
		
		dAL.add(d1); dAL.add(d2); dAL.add(d3); dAL.add(1, d4); //dAL.add(1, d5);
		System.out.println(dAL);
		
		//dAL.remove(1);
		d1 = 56.0;
		System.out.println(dAL);
		
	}
}
