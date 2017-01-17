package tools.parse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StringParser {

	public static int getIndexOfWord(String w, String chain) {
		/**
		 * get the index of the first character of the word w if chain contains
		 * the word w or -1 if chain does'nt contains w.
		 */
		int i = w.length();
		while (i < chain.length()) {
			if (chain.substring(i - w.length(), i) == w)
				return i;
			i++;
		}
		return -1;
	}
	
	public static String getNextWord(String line, int index,char separator){
		/**get the whole text between index and the next separation*/
		int last = index;
		while(line.charAt(index) != separator)
			index++;
		String word = line.substring(last,index);
		System.out.println(word);
		return word;
	}
	
	public static ArrayList<String> readData(String fileName) {
		/**Read the file and place each lines of the text in an ArrayList<String>*/
		ArrayList<String> lines = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				lines.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}


}
