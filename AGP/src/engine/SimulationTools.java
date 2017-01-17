package engine;

import java.util.HashMap;


import data.Hotel;
import data.Offer;
import data.TouristAttraction;
import data.constants.Constants;
import data.constants.Transport;
import lucene.DataReader;
import tools.math.MathTools;

public class SimulationTools {
	public static HashMap<String, Integer> datas = new HashMap<String, Integer>();

	public static int comfort(Offer offer) {
		int activity = offer.getAllActivityTime();
		int transport = offer.getAllTransportTime();
		int hotelTime = Constants.MINUTES_IN_DAY - (activity + transport);
		return (int) MathTools
				.boundValue((activity * (0.75) + hotelTime * (0.1 * offer.getHotel().getRange()) - transport)
						/ Constants.COMFORT_REGULATION, 1, 5);
	}

	public static int getTimeData(TouristAttraction attraction, Hotel hotel, HashMap<String, Integer> datas) {
		return datas.isEmpty() ? DataReader.loadTransportTime().get(hotel.getName() + attraction.getName())
				: datas.get(hotel.getName() + attraction.getName());
	}

	public static float getTransportCost(Hotel hotel, TouristAttraction attraction, Transport transport) {
		return getTransportTime(hotel, attraction, transport) * transport.getPrice();
	}

	public static float getFullPrice(Hotel hotel, TouristAttraction attraction, Transport transport) {
		return getTransportCost(hotel, attraction, transport) + attraction.getPrice();
	}

	public static float getTransportTime(Hotel hotel, TouristAttraction attraction, Transport transport) {
		return getTimeDatas().get(hotel.getName() + attraction.getName() + transport);
	}

	private static HashMap<String, Integer> getTimeDatas() {
		return datas.isEmpty() ? DataReader.loadTransportTime() : datas;
	}

	public static int getTotalTime(Hotel hotel, TouristAttraction attraction, Transport transport) {
		return getTimeData(attraction, hotel, datas) + attraction.getDuration();
	}

}
