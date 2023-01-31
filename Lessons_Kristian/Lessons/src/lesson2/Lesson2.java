package lesson2;
import java.io.*;
public class Lesson2 {

	public static void main(String[] args) throws IOException{
		Database db = new Database();

		//System.out.println(db.load("inputFile.txt"));
		//System.out.println(System.getProperty("user.dir"));
		//Display default directory
		//System.out.println(db.save("outputFile.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = "Null";
		while(!in.equals("end")) {
			
			System.out.print("Your command: ");
			in = br.readLine();
			
			if(in.equals("load")) {
				System.out.println(db.load("inputFile.txt"));
			} else if(in.equals("save")) {
				System.out.println(db.save("outputFile.txt"));
			}
		
		}
		
	}

}
