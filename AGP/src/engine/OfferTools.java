package engine;

import java.util.ArrayList;
import java.util.HashMap;

import data.Hotel;
import data.InputData;
import data.Offer;
import data.TouristAttraction;
import data.Trip;
import data.constants.Constants;
import tools.math.MathTools;
public class OfferTools implements CaculationTools{
	public static int comfort(Offer offer) {
		int activity = getAllActivityTime(offer);
		int transport = getAllTransportTime(offer);
		int hotelTime = Constants.MINUTES_IN_DAY - (activity + transport);
		return (int) MathTools
				.boundValue((activity * (0.75) + hotelTime * (0.5 * offer.getHotel().getRange()) - transport)
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

	public static void getWantedHotel(HashMap<String, Hotel> hotels,InputData input){
		for(String hotelid : hotels.keySet())
			if(MathTools.absoluteValue(hotels.get(hotelid).getRange() - input.getComfort()) > 1)
				hotels.remove(hotelid);
	}
	
	public static void getWantedAttractions(HashMap<String, TouristAttraction> attractions,InputData input){
		for(String attractionid : attractions.keySet())
			if(input.getType() !=  attractions.get(attractionid).getType())
				attractions.remove(attractionid);
	}
}
