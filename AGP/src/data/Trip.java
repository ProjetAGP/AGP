package data;

import java.util.ArrayList;
import java.util.HashMap;

import data.constants.Constants;
import data.constants.Transport;
import engine.SimulationTools;

public class Trip {
	private ArrayList<TouristAttraction> attractions = new ArrayList<TouristAttraction>();
	private HashMap<String, Transport> transports = new HashMap<String, Transport>();

	private float price = 0;

	public float getPrice(Hotel hotel) {
		if (price == 0)
			for (TouristAttraction attraction : attractions)
				price += SimulationTools.getFullPrice(hotel, attraction, getAssociatedTransport(attraction));
		return price;
	}

	public Transport getAssociatedTransport(TouristAttraction touristAttraction) {
		return transports.get(touristAttraction.getName());
	}

	public boolean addAttractionAndAssocaite(TouristAttraction attraction, Hotel hotel, Transport transport) {
		if (!attractions.contains(attraction)) {
			transports.put(attraction.getName(), transport);
			System.out.println(hotel.toString() + attraction.toString() + getAssociatedTransport(attraction));

			if (getFullTime(hotel) + SimulationTools.getTotalTime(hotel, attraction,
					getAssociatedTransport(attraction)) > Constants.MAX_DISPONIBLE_TIME) {
				attractions.add(attraction);
				return true;
			}
		}
		return false;
	}

	public int getFullTime(Hotel hotel) {
		int time = 0;
		for (TouristAttraction attraction : attractions)
			time += SimulationTools.getTotalTime(hotel, attraction, getAssociatedTransport(attraction));
		return time;
	}

	public int getAllTransportTime(Hotel hotel) {
		int time = 0;
		for (TouristAttraction attraction : attractions)
			time += SimulationTools.getTransportTime(hotel, attraction, getAssociatedTransport(attraction));
		return time;
	}

	public int getAllActivityTime() {
		int time = 0;
		for (TouristAttraction attraction : attractions)
			time += attraction.getDuration();
		return time;
	}

	public String toString() {
		return "Trip [attractions=" + attractions + ", price=" + price + "]";
	}

}
