package lecture6;
import java.io.*;

public class Lecture6 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("File.txt");
		
		FileReader fr = new FileReader(f);
		BufferedReader reader = new BufferedReader(fr);
		
		String line;
		while ( (line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
		
		FileWriter fWr = new FileWriter("File2.txt",true);
		BufferedWriter writer = new BufferedWriter(fWr);
		
		writer.write("Hello");
		
		writer.flush();
		
		/*
		String s = "Hello";
		int i;
		try {
			i = Integer.parseInt(s);
			System.out.println(i);
		}
		catch (NumberFormatException ierr) {
			System.out.println("Mistake\n-------\n");
			ierr.printStackTrace();
		}
		 */
		
	}
}