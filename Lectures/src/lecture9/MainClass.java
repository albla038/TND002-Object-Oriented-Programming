package lecture9;

public class MainClass {

	public static void main(String[] args) {
		Dictionary td = new Dictionary();
		
		Dictionary.Word w = td.new Word("instance Hi");
		
		Dictionary.WordS wS = new Dictionary.WordS("class Hi");
		System.out.println(wS.getWord());
	}

}
