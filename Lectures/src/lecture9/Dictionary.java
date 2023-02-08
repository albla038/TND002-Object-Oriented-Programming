package lecture9;
import java.util.ArrayList;

public class Dictionary {
	
	private ArrayList<Word> theList;
	private ArrayList<WordS> theListS;
	
	public Dictionary() {
		theList = new ArrayList<Word>();
		theListS = new ArrayList<WordS>();
	}
	
	public void addWord(String arg) {
		theList.add(new Word(arg));
	}
	
	public void addWordS(String arg) {
		theListS.add(new WordS(arg));
	}
	
	public String listSize() {
		return "Instance: " + theList.size() + " and Class: " + theListS.size();
	}
	
	public String getTheWord(int arg) {
		return theList.get(arg).getWord();
	}
	
	public class Word { // inner class
		private String theWord;
		public Word(String arg) {
			theWord = arg;
		}
		public String getWord() {
			return theWord;
		}
	}
	
	public static class WordS { // inner class
		private String theWord;
		public WordS(String arg) {
			theWord = arg;
		}
		public String getWord() {
			return theWord;
		}
	}
}
