package data;

import java.util.ArrayList;

import engine.OfferTools;

public class Offer {
	private ArrayList<Trip> trips = new ArrayList<Trip>();
	private Hotel hotel;
	private int duration = 7;// in days.
	// private float price = 0;

	public Offer(Hotel hotel) {
		this.hotel = hotel;
	}

	public void addTrip(Trip trip) {
		trips.add(trip);
		duration++;
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
		return "Offer [trips=" + trips + ", hotel=" + hotel + ", duration=" + duration + ", price="
				+ OfferTools.getPrice(this) + ", comfort=" + OfferTools.comfort(this) + "]";
	}

}
