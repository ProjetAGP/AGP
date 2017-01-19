package simulation;

import java.util.ArrayList;

import data.constants.Constants;
import tools.parse.StringParser;

public class ReadTimesTest {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		words = StringParser.sliceLine(StringParser.readData(Constants.HOTELS_FILE).get(0), ',', ';');
		System.out.println(words.get(0));
		System.out.println(words.get(1));
		System.out.println(words.get(2));
	}
}
