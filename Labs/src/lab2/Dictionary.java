package lab2;
import java.util.*;
public class Dictionary {
	private ArrayList<Word> theList;
	private ArrayList<Word> backup = null;
	
	public Dictionary() {
		theList = new ArrayList<Word>();
	}
	
	public String addString(String arg) {
		Word newWord = new Word(arg, 1);
		boolean found = false;
		
		for (int i = 0; i < theList.size(); i++) {
			if (theList.get(i).getWord().equals(arg)) {
				found = true;
				theList.set(i, newWord = new Word(arg, theList.get(i).getCount() + 1));
			}
		}
		
		if (!found) {
			theList.add(newWord);
		}
		
		return newWord.toString();
	}
	
	public String sortList(int arg) {
		
		if (!(arg == 1 || arg == 2 || arg == 0)) {
			return "Invalid argument";
		}
		
		if(backup == null) {
			backup = new ArrayList<Word>();
			backup.addAll(theList);
		}
		
		if(arg == Word.ORIGINAL) {
			theList = backup;
			Word.setCriterion(Word.ORIGINAL);
			return "Word list was reset";
		} else {
			Word.setCriterion(arg);
			for(int i = 0;i < theList.size() - 1; i++) {
				if(theList.get(i).compareTo(theList.get(i + 1)) == -1) {
					theList.set(i + 1, theList.set(i, theList.get(i + 1)));
					//Collections.swap(theList, i, i + 1);
				}
			}
			
			String criterion;
			
			if(Word.getCriterion() == Word.BYNAME) {
				criterion = "Sorted alphabetically";
			} else {
				criterion = "Sorted by counts";
			}
			
			return criterion;
		}
			
	}
	
	public String returnWord(int arg) {
		if (arg < theList.size()) {
			return theList.get(arg).toString();
		} else {
			return "end";
		}
	}
	
	public String toString() {
		
		String result = "Content:\n";
		
		for (Word word : theList) {
			result += word.toString() + "\n";
		}
		
		return result;
	}
	
	
}
