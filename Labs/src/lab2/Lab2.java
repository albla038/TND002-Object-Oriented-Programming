package lab2;

import java.io.*;

public class Lab2 {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		Dictionary theDictionary = new Dictionary();
		File file;
		
		int i = 0;
		do {
			
			if (i > 0) {
				System.out.print("No file found. ");
			}
			
			System.out.print("Type filename: ");
			file = new File(reader.readLine());
			i++;
		} while (!file.exists() && i < 3);
		
		reader.close();
		
		if (!file.exists()) {
			System.out.print("No file found... Terminating program...");
			return;
		}
		
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(file));
			
			String result = "";
			String input;
			while ((input = fileReader.readLine()) != null) {
				result += input + " ";
			}
			
			fileReader.close();
			
			result = result.trim();
			
			String[] array = result.split(" +");
			
			for (int j = 0; j < array.length; j++) {
				if (!isNumeric(array[j])) {
					System.out.println(theDictionary.addString(array[j]));
				}
			}
		} catch (IOException e) {
			System.out.print("Error when trying to read file");
		}
		
		
		//OUTPUT
		System.out.println(theDictionary);
		
		System.out.println(theDictionary.sortList(Word.BYCOUNTS));
		System.out.println(theDictionary);
		
		System.out.println(theDictionary.sortList(Word.BYNAME));
		System.out.println(theDictionary);
		
		System.out.println(theDictionary.sortList(Word.ORIGINAL));
		System.out.println(theDictionary);
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("result.txt")));
			
			writer.write(theDictionary.toString());

			writer.write(theDictionary.sortList(Word.BYCOUNTS));
			writer.write(theDictionary.toString());
			
			writer.write(theDictionary.sortList(Word.BYNAME));
			writer.write(theDictionary.toString());
			
			writer.write(theDictionary.sortList(Word.ORIGINAL));
			writer.write(theDictionary.toString());
			
			writer.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static boolean isNumeric(String arg) {
		try {
			Double.valueOf(arg);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
