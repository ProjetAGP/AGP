package engine;

import data.Offer;
import data.Trip;
import data.constants.Constants;
import tools.math.MathTools;
public class OfferTools implements CaculationTools{
	public static int comfort(Offer offer) {
		int activity = getAllActivityTime(offer);
		int transport = getAllTransportTime(offer);
		int hotelTime = Constants.MINUTES_IN_DAY - (activity + transport);
		return (int) MathTools
				.boundValue((activity * (0.75) + hotelTime * (0.1 * offer.getHotel().getRange()) - transport)
						/ Constants.COMFORT_REGULATION, 1, 5);
	}
	
	public static int getAllTransportTime(Offer offer) {
		int time = 0;
		for (Trip trip : offer.getTrips())
			time += TripTools.getAllTransportTime(offer.getHotel(),trip);
		return time;
	}

	public static float getHotelCost(Offer offer) {
		return offer.getHotel().getDailyPrice() * offer.getDuration();
	}
	
	public static float getPrice(Offer offer) {
		return getHotelCost(offer) + getTripCost(offer);
	}

	public static float getTripCost(Offer offer) {
		float price = 0;
		for (Trip trip : offer.getTrips()){
			System.out.println(trip);
			price = trip.getPrice(offer.getHotel());
		}
		return price;
	}

	public static int getAllActivityTime(Offer offer) {
		int time = 0;
		for (Trip trip : offer.getTrips())
			time += TripTools.getAllActivityTime(trip);
		return time;
	}

}
