package data;

import java.util.ArrayList;

import data.constants.Constants;
import data.constants.Transport;

public class Trip {
	private ArrayList<TouristAttraction> attractions = new ArrayList<TouristAttraction>();
	private float price = 0;

	public float getPrice(Hotel hotel) {
		if (price == 0)
			for (TouristAttraction attraction : attractions)
				price += TouristAttraction.getFullPrice(hotel, attraction);
		return price;
	}

	public boolean addTouristAttraction(Hotel hotel, TouristAttraction attraction) {
		if (getAllActivityTime() + getAllTransportTime(hotel) + attraction.getDuration()
				+ TouristAttraction.getTransportTime(hotel, attraction) > Constants.MAX_DISPONIBLE_TIME)
			return false;
		attractions.add(attraction);
		return true;
	}

	public int getAllTransportTime(Hotel hotel) {
		int time = 0;
		for (TouristAttraction attraction : attractions)
			time += TouristAttraction.getTransportTime(hotel, attraction);
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
