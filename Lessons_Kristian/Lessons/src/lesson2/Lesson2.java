package lesson2;

public class Lesson2 {

	public static void main(String[] args) {
		Database db = new Database();

		System.out.println(db.load("inputFile.txt"));
		//System.out.println(System.getProperty("user.dir"));
		//Display default directory
	}

}
