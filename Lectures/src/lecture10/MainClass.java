package lecture10;

import java.util.ArrayList;
import java.util.Collections;

public class MainClass {
	
	public static void main(String[] args) {
		
		Rectangle r1 = new Rectangle(1, 1);
		Rectangle r2 = new Rectangle(1, 2);
		
		System.out.println(r2.compareTo(r1));
		if (r1 instanceof Rectangle) System.out.println("Hi");
		
		
		ArrayList<Rectangle> tL = new ArrayList<Rectangle>();
		
		tL.add(new Rectangle(1, 1));
		tL.add(new Rectangle(2, 4));
		tL.add(new Rectangle(3, 0.5));
		tL.add(new Rectangle(4, 2.5));
		
		Collections.sort(tL);
		for (int i = 0; i < tL.size(); i++) {
			System.out.println(tL.get(i));
		}
	}
}
