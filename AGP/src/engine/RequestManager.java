package engine;

import java.util.ArrayList;
import java.util.HashMap;

import data.Hotel;
import data.InputData;
import data.TouristAttraction;
import data.Trip;

public class RequestManager {

	public HashMap<String, ArrayList<Trip>> getRequestedTrip(HashMap<String, Hotel> hotels,
			HashMap<String, TouristAttraction> attractions,InputData inputData) {
		HashMap<String, ArrayList<Trip>> trips = new HashMap<String, ArrayList<Trip>>();	
		for(String hotelName : hotels.keySet())
			trips.put(hotelName, getHotelTrips(hotels.get(hotelName),attractions,inputData));
		return trips;
	}

	private ArrayList<Trip> getHotelTrips(Hotel hotel, HashMap<String, TouristAttraction> attractions,
			InputData inputData) {
			
		return null;
	}
}
