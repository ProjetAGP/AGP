package tools.parse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StringParser {

	public static StringParseGenerable  generateFromParse(StringParseGenerable item ,String line,char separator,char endOfLine){
		ArrayList<String> args = sliceLine(line,separator,endOfLine);
		item.generateItem(args);
		return item;
	}
	
	public static StringParseGenerable  generateFromParse(StringParseGenerable item ,String line,char separator){
		ArrayList<String> args = sliceLine(line,separator);
		item.generateItem(args);
		return item;
	}
	
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
		while(line.charAt(index) != separator && !isLineEnd(index, line))
			index++;
		String word = line.substring(last,index);
		System.out.println(word);
		return word;
	}
	
	public static String getNextWord(String line, int index,char separator,char endOfLine){
		/**get the whole text between index and the next separation*/
		int last = index;
		while(line.charAt(index) != separator && line.charAt(index) != endOfLine)
			index++;
		String word = line.substring(last,index);
		return word;
	}
	
	public static ArrayList<String> sliceLine(String line,char separator,char endOfLine){
		/**get the whole text between index and the next separation*/
		ArrayList<String> words = new ArrayList<String>();
		int index = 0;
		while(true)
		{
			String word = getNextWord(line, index, separator, endOfLine);
			words.add(word);
			index += word.length();
			if(line.charAt(index) == endOfLine)break;
			index++;
		}
		return words;
	}
	
	
	public static ArrayList<String> sliceLine(String line,char separator){
		/**get the whole text between index and the next separation*/
		ArrayList<String> words = new ArrayList<String>();
		int index = 0;
		while(true)
		{
			String word = getNextWord(line, index,separator);
			words.add(word);
			index += word.length();
			if(isLineEnd(index, line))break;
			index++;
		}
		return words;
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
	
	public static boolean isLineEnd(int index,String line){
		return index == line.length();
	}
}
