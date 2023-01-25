package lecture6;

import java.io.*;

public class IOTest {
	private static BufferedReader reader =
			new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		System.out.println(readFromConsole());
	}

	private static String readFromConsole() {
		System.out.print("Type something: ");
		try {
			return "You typed: " + reader.readLine();
		} catch (IOException ierr) {
			return "IO Exception";
		}
	}
}
