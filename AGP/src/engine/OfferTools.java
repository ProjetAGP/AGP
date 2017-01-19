package engine;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import lucene.LuceneTester;
import persistence.HotelData;
import persistence.PersistenceData;
import persistence.TouristicSiteData;
import tools.math.MathTools;
import data.Hotel;
import data.InputData;
import data.Offer;
import data.TouristAttraction;
import data.Trip;
import data.constants.Constants;

public class OfferTools implements CaculationTools {

	public static int comfort(Offer offer) {
		int activity = getAllActivityTime(offer);
		int transport = getAllTransportTime(offer);
		int hotelTime = Constants.MINUTES_IN_DAY - (activity + transport);
		return (int) MathTools
				.boundValue(
						(getHotelComfort(offer, hotelTime, transport) + getActivityComfort(
								transport, hotelTime))
								/ Constants.COMFORT_REGULATION, 1, 5);
	}

	private static float getActivityComfort(float activity, float transport) {
		return (float) MathTools.boundValue(activity - transport, 1, 3);
	}

	private static float getHotelComfort(Offer offer, float hotelTime,
			float transport) {
		return (float) MathTools.boundValue(hotelTime
				* offer.getHotel().getRange() - transport, 1, 3);
	}

	public static int getAllTransportTime(Offer offer) {
		int time = 0;
		for (Trip trip : offer.getTrips())
			time += TripTools.getAllTransportTime(offer.getHotel(), trip);
		return time;
	}

	public static List<HotelData> getResquestHotel(InputData input)
			throws IOException {

		PersistenceData p = new PersistenceData();
		p.removeHotels();
		p.persisteHotel("HRANGE='" + input.getComfort() + "' AND PRICE < "
				+ input.getBudget());

		return p.getHotels();
	}

	public static List<TouristicSiteData> getRequestSite(InputData input, String keyWord) {
		System.out.println(keyWord);
		LuceneTester l = new LuceneTester(keyWord);

		PersistenceData p = new PersistenceData();

		for (int i = 0; i < l.getResultsLucene().size(); i++) 

			p.persisteSite("NAME='" + l.getResultsLucene().get(i) + "'");

		
		return p.getTouristicSites();

	}

	public static float getHotelCost(Offer offer) {
		return offer.getHotel().getDailyPrice() * offer.getDuration();
	}

	public static float getPrice(Offer offer) {
		return getHotelCost(offer) + getTripCost(offer);
	}

	public static float getTripCost(Offer offer) {
		float price = 0;
		for (Trip trip : offer.getTrips()) {
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

	public static void removeUnwantedHotels(HashMap<String, Hotel> hotels,
			InputData input) {
		// TO TEST
		for (String hotelid : hotels.keySet())
			if (MathTools.absoluteValue(hotels.get(hotelid).getRange()
					- input.getComfort()) > 1)
				hotels.remove(hotelid);
	}

	public static void removeUnwantedAttractions(
			HashMap<String, TouristAttraction> attractions, InputData input) {
		for (String attractionid : attractions.keySet())
			if (input.getType() != attractions.get(attractionid).getType())
				attractions.remove(attractionid);
	}
}
