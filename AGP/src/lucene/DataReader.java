package lucene;

import java.util.ArrayList;
import java.util.HashMap;

import data.Hotel;
import data.TouristAttraction;
import data.constants.Constants;
import data.constants.TouristAttractionType;
import tools.parse.StringParser;

public class DataReader {

	public static HashMap<String, Integer> loadTransportTime() {
		HashMap<String, Integer> datas = new HashMap<String, Integer>();
		ArrayList<String> lines = StringParser.readData(Constants.TIMES_FILE);
		for (String line : lines)
			readTransportLine(line, datas);
		return datas;
	}

	public static HashMap<String, Hotel> loadHotel() {
		HashMap<String, Hotel> hotels = new HashMap<String, Hotel>();
		ArrayList<String> lines = StringParser.readData(Constants.HOTELS_FILE);
		for (String line : lines)
			readHotelLine(line, hotels);
		return hotels;
	}

	public static HashMap<String, TouristAttraction> loadSites() {
		HashMap<String, TouristAttraction> attractions = new HashMap<String, TouristAttraction>();
		ArrayList<String> lines = StringParser.readData(Constants.SITES_FILE);
		for (String line : lines)
			readSitesLine(line, attractions);
		return attractions;

	}

	private static void readSitesLine(String line, HashMap<String, TouristAttraction> attractions) {
		int index = 0;
		String attractionName = StringParser.getNextWord(line, index, ',');
		index += attractionName.length() + 1;
		String type = StringParser.getNextWord(line, index, ',');
		index += type.length() + 1;
		String duration = StringParser.getNextWord(line, index, ',');
		index += duration.length() + 1;
		String price = StringParser.getNextWord(line, index, ';');
		TouristAttractionType attractionType = type == "historic" ? TouristAttractionType.HISTORIC
				: TouristAttractionType.LEISURE_SITE;
		attractions.put(attractionName, new TouristAttraction(attractionName, attractionType,
				Integer.parseInt(duration), Float.parseFloat(price)));
	}

	private static void readHotelLine(String line, HashMap<String, Hotel> hotels) {
		/* format : hotelName,range,price; */
		int index = 0;
		String hotelName = StringParser.getNextWord(line, index, ',');
		index += hotelName.length() + 1;
		String range = StringParser.getNextWord(line, index, ',');
		index += range.length() + 1;
		String price = StringParser.getNextWord(line, index, ';');
		hotels.put(hotelName, new Hotel(hotelName, Integer.parseInt(range), Integer.parseInt(price)));

	}

	private static void readTransportLine(String line, HashMap<String, Integer> datas) {
		/* format : hotelName,attractionName,busTime,boatTime; */
		int index = 0;
		String hotelName = StringParser.getNextWord(line, index, ',');
		index += hotelName.length() + 1;
		String attractionName = StringParser.getNextWord(line, index, ',');
		index += attractionName.length() + 1;
		String bus = StringParser.getNextWord(line, index, ',');
		index += bus.length() + 1;
		String boat = StringParser.getNextWord(line, index, ';');
		System.out.println(hotelName + " " + attractionName + " " + bus + " " + boat);
		int boatTime = Integer.parseInt(boat);
		int busTime = Integer.parseInt(bus);
		addTransportLine(datas, hotelName, attractionName, boatTime);
		addTransportLine(datas, hotelName, attractionName, busTime);
	}

	private static void addTransportLine(HashMap<String, Integer> datas, String hotelName, String attractionName,
			int value) {
		if (value > 0)
			datas.put(hotelName + attractionName, value);
	}

}
