import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Vocabulary {
	private ArrayList<Word> Words = new ArrayList<Word>();
	
//	Initializes a vocabulary from given directory.
	Vocabulary(String dir){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(dir));
			String currentLine = reader.readLine();
			while((currentLine = reader.readLine()) != null) {
				// Splits the line into primitive array, and initialize several variables
				// To be used later to create a new word object
				String arr[] = currentLine.split(",");
				String JLPTLvl = arr[0];
				String kanji = arr[1];
				String furi = arr[2];
				String meanings = "";
				
				// Iterates through the rest of the element in the 'arr' array, inputting them into the meaning string
				for(int i = 3; i < arr.length; i++) {
					if(i == 3) {
						meanings += arr[i].replace("\"", "");						
					} else {
						meanings += ", " + arr[i].replace("\"", "");
					}
				}
				Words.add(new Word(JLPTLvl,kanji,furi,meanings));
			}
			reader.close();
		}
		catch(IOException e) {
			System.out.println("Error occured, file not found");
			System.exit(0);
		}
	}
	
	public ArrayList<Word> getVocab() {
		return Words;
	}
	public Word getWordAt(int index) {
		return Words.remove(index);
	}
	public int size() {
		return Words.size();
	}
	
	
}
