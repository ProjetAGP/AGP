package lucene;

import java.util.ArrayList;
import java.util.HashMap;


import data.Hotel;
import data.TouristAttraction;
import data.constants.Constants;
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
		for (String line : lines) {
			Hotel hotel = new Hotel();
			StringParser.generateFromParse(hotel, line, ',', ';');
			hotels.put(hotel.getName(), hotel);
		}
		return hotels;
	}

	public static HashMap<String, TouristAttraction> loadSites() {
		HashMap<String, TouristAttraction> attractions = new HashMap<String, TouristAttraction>();
		ArrayList<String> lines = StringParser.readData(Constants.SITES_FILE);
		for (String line : lines) {
			TouristAttraction attraction = new TouristAttraction();
			StringParser.generateFromParse(attraction, line, ',', ';');
			attractions.put(attraction.getName(), attraction);
		}
		return attractions;

	}

	private static void readTransportLine(String line, HashMap<String, Integer> datas) {
		/* format : hotelName,attractionName,busTime,boatTime; */
		ArrayList<String> args = StringParser.sliceLine(line, ',', ';');
		int busTime = Integer.parseInt(args.get(2));
		int boatTime = Integer.parseInt(args.get(3));
		addTransportLine(datas, args.get(0), args.get(1), "bus", busTime);
		addTransportLine(datas, args.get(0), args.get(1), "boat", boatTime);
	}

	private static void addTransportLine(HashMap<String, Integer> datas, String hotelName, String attractionName,
			String type, int value) {
		if (value > 0) {
			String key = hotelName + attractionName + type;
			datas.put(key, value);
		}
	}

}
