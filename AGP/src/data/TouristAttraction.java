package data;

import data.constants.Constants;
import data.constants.TouristAttractionType;
import data.constants.Transport;

public class TouristAttraction {

	private String name = "attraction";
	private TouristAttractionType type;
	private Transport transport;
	private int duration = 60; // in minutes
	private float price = 0;
	
	public TouristAttraction(String name, TouristAttractionType type, Transport transport, int duration, float price) {
		this.name = name;
		this.type = type;
		this.transport = transport;
		this.duration = duration;
		this.price = price;
	}

	public static float getTransportCost(Hotel hotel,TouristAttraction attraction) {
		return  getTransportTime(hotel, attraction) *attraction.transport.getPrice();
	}

	public String getName() {
		return name;
	}

	public TouristAttractionType getType() {
		return type;
	}

	public int getDuration() {
		return duration;
	}

	public float getPrice() {
		return price;
	}

	public Transport getTransport() {
		return transport;
	}

	public static float getFullPrice(Hotel hotel,TouristAttraction attraction) {
		return getTransportCost(hotel,attraction) + attraction.getPrice();
	}

	private static Transport getTransport(Hotel hotel, TouristAttraction attraction) {
		
		return null;
	}

	public static float getTransportTime(Hotel hotel,TouristAttraction attraction) {
		// TODO get data in database.
		Transport transport = attraction.getTransport();
		int index =0;
		switch (hotel.getName()) {
		case "hotel1":
			index = 0;
			break;
		case "hotel2":
			index = 1;
			break;
		case "hotel3":
			index = 2;
			break;
		case "hotel4":
			index = 3;
			break;
		case "hotel5":
			index = 4;
			break;
		}
		int time = transport == Transport.BOAT ? Constants.BOAT_DURATION[index] : Constants.BUS_DURATION[index];
		switch (attraction.getName()) {
		case "attration1":
			return (float)0.25 * time;
		case "attration2":
			return (float) 0.5 * time;
		case "attration3":
			return (float) 0.75 * time;
		case "attration4":
			return (float) time ;
		case "attration5":
			return (float) 1.25 * time;
		}
		return 0;
	}

	public String toString() {
		return "TouristAttraction [name=" + name + ", type=" + type + ", duration=" + duration + ", price=" + price
				+ "]";
	}

}
