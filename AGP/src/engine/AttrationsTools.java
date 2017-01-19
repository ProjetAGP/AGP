package engine;

import java.util.HashMap;

import data.Hotel;
import data.TouristAttraction;
import data.constants.Transport;
import lucene.DataReader;

public class AttrationsTools implements CaculationTools{
	public static HashMap<String, Integer> datas = new HashMap<String, Integer>();

	public static float getTransportCost(Hotel hotel, TouristAttraction attraction, Transport transport) {
		return getTransportTime(hotel, attraction, transport) * transport.getPrice();
	}

	public static float getFullPrice(Hotel hotel, TouristAttraction attraction, Transport transport) {
		return getTransportCost(hotel, attraction, transport) + attraction.getPrice();
	}

	public static int getTransportTime(Hotel hotel, TouristAttraction attraction, Transport transport) {
		String type = transport == Transport.BOAT ? "boat" : "bus";
		String key = hotel.getName() + attraction.getName() + type;
		return datas.get(key) == null ? 0 : getTimeDatas(datas).get(key);
	}

	private static HashMap<String, Integer> getTimeDatas(HashMap<String, Integer> datas) {
		if(datas.isEmpty()) datas=DataReader.loadTransportTime(); 
		return datas;
	}

	public static int getTotalTime(Hotel hotel, TouristAttraction attraction, Transport transport) {
		int k = getTransportTime(hotel, attraction, transport);
		return k;
	}

}
