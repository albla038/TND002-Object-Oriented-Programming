package lab2;

public class Word {
	
	public static final int ORIGINAL = 0, BYNAME = 1, BYCOUNTS = 2;
	private String theWord;
	private int count;
	private static int sortCriterion = ORIGINAL;
	
	public Word(String word, int arg) {
		theWord = word;
		count = arg;
	}
	
	public int getCount() {
		return count;
	}
	
	public String getWord() {
		return theWord;
	}
	
	public static void setCriterion(int arg) {
		sortCriterion = arg;
	}
	
	public static int getCriterion() {
		return sortCriterion;
	}
	
	public int compareTo(Word arg) {
		
		int result = -2;
		
		if (sortCriterion == ORIGINAL) {
			result = 2;
		}
		
		else if (sortCriterion == BYNAME) {
			int temp = theWord.compareTo(arg.theWord);
			if (temp < 0) {
				result = -1;
			} else if (temp > 0) {
				result = 1;
			} else {
				result = 0;
			}
		}
		
		else if (sortCriterion == BYCOUNTS) {
			if (count < arg.getCount()) {
				result = -1;
			} else if (count > arg.getCount()) {
				result = 1;
			} else {
				result = 0;
			}
		}
		
		return result;
		
		
		/*
		else if (sortCriterion == BYNAME || sortCriterion == BYCOUNTS) {
			int temp;
			int temp2;
			if (sortCriterion == BYNAME) {
				temp = theWord.compareTo(arg.theWord);
				temp2 = 0;
			} else {
				temp = count;
				temp2 = arg.getCount();
			}
			
			if (temp < temp2) {
				result = -1;
			} else if (temp > temp2) {
				result = 1;
			} else {
				result = 0;
			}
		}
		*/
		
		}
	
	public String toString() {
		return String.format("Word: %10s   Count: %3d", theWord,count);
	}
}
