package lecture6;
import java.io.*;

public class Lecture6 {

	public static void main(String[] args) throws IOException {
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		String in;
		do {
			System.out.print("Input: ");
			 in = consoleReader.readLine();
			System.out.println(in);	
		} while (!in.equals("end"));
		
		consoleReader.close();
		
		System.out.println("\nDone");
	}

}