package engine;

import data.Hotel;
import data.TouristAttraction;
import data.Trip;

public class TripTools implements CaculationTools{
	public static int getFullTime(Hotel hotel, Trip trip) {
		int time = 0;
		for (TouristAttraction attraction : trip.getAttractions())
			time += AttrationsTools.getTotalTime(hotel, attraction, trip.getAssociatedTransport(attraction));
		return time;
	}

	public static int getAllTransportTime(Hotel hotel, Trip trip) {
		int time = 0;
		for (TouristAttraction attraction : trip.getAttractions())
			time += AttrationsTools.getTransportTime(hotel, attraction, trip.getAssociatedTransport(attraction));
		return time;
	}

	public static int getAllActivityTime(Trip trip) {
		int time = 0;
		for (TouristAttraction attraction : trip.getAttractions())
			time += attraction.getDuration();
		return time;
	}

	public float getPrice(Hotel hotel, Trip trip) {
		float price = trip.getPrice();
		if (price == 0)
			for (TouristAttraction attraction : trip.getAttractions())
				price += AttrationsTools.getFullPrice(hotel, attraction, trip.getAssociatedTransport(attraction));
		trip.setPrice(price);
		return price;
	}

}
