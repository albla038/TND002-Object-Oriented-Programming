package lesson2;

public class Lesson2 {

	public static void main(String[] args) {
		
		Database db = new Database();
		
		String input = db.load("inputFile.txt");
		System.out.println(input);
		
		String result = db.save("saveFile.txt");
		System.out.println(result);
	}
}
