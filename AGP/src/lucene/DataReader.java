package lucene;

import java.util.ArrayList;
import java.util.HashMap;

import data.Hotel;
import data.TouristAttraction;
import data.constants.Constants;
import data.constants.TouristAttractionType;
import data.constants.Transport;
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
		// format:attractionName,type,duration,price;
		ArrayList<String> args = StringParser.sliceLine(line, ',', ';');
		TouristAttractionType attractionType = args.get(1).equals("historic") ? TouristAttractionType.HISTORIC
				: TouristAttractionType.LEISURE_SITE;
		attractions.put(args.get(0), new TouristAttraction(args.get(0), attractionType, Integer.parseInt(args.get(2)),
				Float.parseFloat(args.get(3))));
	}

	private static void readHotelLine(String line, HashMap<String, Hotel> hotels) {
		/* format : hotelName,range,price; */
		ArrayList<String> args = StringParser.sliceLine(line, ',', ';');		
		hotels.put(args.get(0), new Hotel(args.get(0), Integer.parseInt(args.get(1)), Integer.parseInt(args.get(2))));
	}

	private static void readTransportLine(String line, HashMap<String, Integer> datas) {
		/* format : hotelName,attractionName,busTime,boatTime; */
		ArrayList<String> args = StringParser.sliceLine(line, ',', ';');
		int busTime = Integer.parseInt(args.get(2));
		int boatTime = Integer.parseInt(args.get(3));
		addTransportLine(datas, args.get(0), args.get(1),"bus",busTime);
		addTransportLine(datas, args.get(0), args.get(1),"boat", boatTime);
	}

	private static void addTransportLine(HashMap<String, Integer> datas, String hotelName, String attractionName,String type,
			int value) {
		if (value > 0){
		String key = hotelName + attractionName +type;
			datas.put(key, value);
		}
	}

}
