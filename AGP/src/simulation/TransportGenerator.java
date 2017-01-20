package simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import data.Hotel;
import data.TouristAttraction;
import lucene.DataReader;
import tools.math.RandomInt;
import tools.parse.StringParser;

public class TransportGenerator {

	public static void main(String[] args) {
		Random rand = new Random();
		HashMap<String, Hotel> hotels = DataReader.loadHotel();
		HashMap<String, TouristAttraction> attractions = DataReader.loadSites();

		System.out.println(hotels);
		System.out.println(attractions);

		ArrayList<String> words = new ArrayList<String>();
		int index = 1;
		for (String hot : hotels.keySet()) {
			for (String atr : attractions.keySet()) {
				int v = RandomInt.generate(2);
				String transport = "";
				if (v == 0 || v == 2) {
					words.add("(" + index + ", " + hot + ", " + atr + ", 'autobus', " + RandomInt.generate(15, 90) + "),");
					index++;
				}
				if (v == 1 || v == 2) {
					words.add("(" + index + ", " + hot + ", " + atr + ", 'boat', " + RandomInt.generate(15, 90) + "),");
					index++;
				}
			}
		}
		for (String word : words)
			System.out.println(word);

	}

}
