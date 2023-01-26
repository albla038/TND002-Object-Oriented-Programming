package lab1;

public class Vector {
	private double x, y, z;
	public static Vector vdef = new Vector(0.0, 0.0, 0.0);
	
	public Vector() {
		setToDefault();
	};
	
	public Vector(double d1, double d2, double d3) {
		x = d1; y = d2; z = d3;
	};
	
	public static void setDefault(Vector arg){
		vdef = arg;
	}
	
	public void setToDefault() {
		x = vdef.x; y = vdef.y; z = vdef.z;
	}
	
	public static Vector plus(Vector arg1, Vector arg2) { 
		double rX = arg1.x + arg2.x,
				rY = arg1.y + arg2.y,
				rZ = arg1.z + arg2.z;
		
		return new Vector(rX, rY, rZ); 
	}
	
	public Vector minus(Vector arg) {
		double rX = x - arg.x,
				rY = y - arg.y,
				rZ = z - arg.z;
		
		return new Vector(rX, rY, rZ); 
	}
	
	public Vector mult(double arg) { //Multiplicerar med en skalär
		double rX = x * arg,
				rY = y * arg,
				rZ = z * arg;
		
		return new Vector(rX, rY, rZ); 
	}
	
	public double mult(Vector arg) { //Multiplicerar elementvis
		double r = x * arg.x + y * arg.y + z * arg.z;
		
		return r; 
	}
	
	public double length() {
		double r = Math.sqrt(x*x + y*y + z*z);
		return r;
	}
	
	public Vector matrixMult(double[][] arg) {
		
		if((arg.length == 3) && (arg[0].length == 3) &&
				(arg[1].length == 3) && (arg[2].length == 3)) {//Kolla om matrisen har 3 rader
			double rX = x * arg[0][0] + y * arg[0][1] + z * arg[0][2],
					rY = x * arg[1][0] + y * arg[1][1] + z * arg[1][2],
					rZ = x * arg[2][0] + y * arg[2][1] + z * arg[2][2];
			
			return new Vector(rX, rY, rZ);
		}
		/*
		int rows = arg.length;
		int preferedRowsAndCols = 3;
		if (rows == preferedRowsAndCols) {//Kolla om matrisen har 3 rader
			
			boolean flag = true;
			
			for (int i = 0; i < rows; i++) {
				if (flag) {
					if (arg[i].length != preferedRowsAndCols) {
						flag = false;
					}
				}
				else break;
			}
			
			if (flag) {
				double rX = x * arg[0][0] + y * arg[0][1] + z * arg[0][2];
				double rY = x * arg[1][0] + y * arg[1][1] + z * arg[1][2];
				double rZ = x * arg[2][0] + y * arg[2][1] + z * arg[2][2];
				
				return new Vector(rX, rY, rZ);
			}
			
		}
		
		*/
		return new Vector(x, y, z);
	}
	
	public void norm() {
		
		double length = length();
		
		x *= (1 / length);
		y *= (1 / length);
		z *= (1 / length);
	}
	
	public int compareTo(Vector arg) {
		if(arg.length() == length()) {
			return 0;
		}
		else if (arg.length() < length()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public String toString() {
		return String.format("Vector = (%4.1f, %4.1f, %4.1f)", x, y, z);
	}
	
	
}
