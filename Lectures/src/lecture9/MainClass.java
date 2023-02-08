package lecture9;

public class MainClass {

	public static void main(String[] args) {
		Dictionary td = new Dictionary();
		td.addWord("Hi");
		td.addWord("Hello");
		System.out.println(td.listSize());
		System.out.println(td.getTheWord(0));
		
		Dictionary.WordS wS = new Dictionary.WordS("Hi");
		System.out.println(wS.getWord());
		
		
	}

}
