package lesson2;
import java.util.ArrayList;
import java.io.*;

public class Database {
	private ArrayList<String> words;
	
	public Database(){
		words = new ArrayList<String>();
	}
	
	public String load(String arg){
		
		String result;
		try {
		BufferedReader br = new BufferedReader(new FileReader(arg));
		String s;
		while((s=br.readLine()) !=null) {
			String[] temp = s.split(" +");
			for (int i=0; i < temp.length; i++) {
				words.add(temp[i]);
			}
		}
		br.close();
		result = String.format("Text loaded: %4d words", words.size());
		
		}
		catch(IOException ierr) {result = "Something went wrong";}
		return result;
	}
	
	public String save(String arg) throws IOException{
		
		String result;
		BufferedWriter bw = new BufferedWriter(new FileWriter(arg, false));
		
		for(int i = 0; i < words.size(); i++) {
			bw.write(words.get(i)); bw.newLine();
		}
		bw.close();
		result = String.format("Wrote %4d words to the file %15s", words.size(), arg);
		
		return result;
	}
	
}
