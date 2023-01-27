package lesson2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Database {
	
	private ArrayList<String> words;
	
	public Database() {
		words = new ArrayList<String>();
	}
	
	public String load(String arg) {
		
		try {
			FileReader fr = new FileReader(arg);
			BufferedReader reader = new BufferedReader(fr);
			
			String line;
			String[] tokens = null;
			while ( (line = reader.readLine()) != null) {
				tokens = line.split(" +");
				for (int i = 0; i < tokens.length; i++) {
					words.add(tokens[i]);
				}
			}
			reader.close();
			
			return String.format("Text loaded: %4d words", tokens.length);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "Error! File not found!";
		} catch (IOException e) {
			e.printStackTrace();
			return "Error! IOException! Something went wrong";
		}
		
	}
	
	public String save(String arg) {
		
		try {
			FileWriter fw = new FileWriter(arg);
			BufferedWriter writer = new BufferedWriter(fw);
			
			for (String word : words) {
				writer.write(word);
				writer.newLine();
			}
			
			writer.close();
			
			return String.format("Wrote: %4d words to the file %15s", words.size(), arg);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "Error! File not found!";
		} catch (IOException e) {
			e.printStackTrace();
			return "Error! IOException! Something went wrong";
		}
	}

}
