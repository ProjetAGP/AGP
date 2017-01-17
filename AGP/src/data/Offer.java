package data;

import java.util.ArrayList;

import engine.SimulationTools;

public class Offer {
	private ArrayList<Trip> trips = new ArrayList<Trip>();
	private Hotel hotel;
	private int duration = 7;// in days.
	// private float price = 0;

	public Offer(Hotel hotel) {
		this.hotel = hotel;
	}

	public float getPrice() {
		return getHotelCost() + getTripCost();
	}

	private float getTripCost() {
		float price = 0;
		for (Trip trip : trips)
			price = trip.getPrice(hotel);
		return price;
	}

	public int getAllActivityTime() {
		int time = 0;
		for (Trip trip : trips)
			time += trip.getAllActivityTime();
		return time;
	}

	public void addTrip(Trip trip) {
		trips.add(trip);
		duration ++;
	}
	
	public int getAllTransportTime() {
		int time = 0;
		for (Trip trip : trips)
			time += trip.getAllTransportTime(hotel);
		return time;
	}

	private float getHotelCost() {
		return hotel.getDailyPrice() * duration;
	}

	public ArrayList<Trip> getTrips() {
		return trips;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public int getDuration() {
		return duration;
	}

	public String toString() {
		return "Offer [trips=" + trips + ", hotel=" + hotel + ", duration=" + duration + ", price=" + getPrice()
				+ ", comfort=" + SimulationTools.comfort(this) + "]";
	}

}
