package lab1;

public class Lab1b {

	public static void main(String[] args) {
		double[][] m1 = {{1, 0, 0},
							{0, 1, 0},
							{0, 0, 1}};

		Vector v1 = new Vector(2.0, 3.5, 4.7);
		
		Vector v2 = new Vector(1, 1, 2);
		
		//System.out.println(v1.matrixMult(m1).toString());
		
		double[][] m2 = {{1, 0},
						{0, 1}};
		
		//System.out.println(v1.matrixMult(m2).toString());
		
		double[][] m3 = {{0, 1, 0},
						{1, 0, 0},
						{0, 0, 1}};
		
		//System.out.println(v1.matrixMult(m3).toString());
		
		System.out.println(Vector.plus(v1, v2));
		System.out.println(v1.minus(v2));
		
		System.out.println(v1.mult(2));
	}

}
