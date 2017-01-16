package data;

import data.constants.Constants;
import data.constants.TouristAttractionType;
import data.constants.Transport;

public class TouristAttraction {

	private String name = "attraction";
	private TouristAttractionType type;
	private int duration = 60; // in minutes
	private float price = 0;

	public TouristAttraction(String name, TouristAttractionType type, int duration, float price) {
		this.name = name;
		this.type = type;
		this.duration = duration;
		this.price = price;
	}

	public static int getTransportTime(Hotel hotel,TouristAttraction attraction) {
		int index = 0;
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
		return Constants.BOAT_DURATION[index] + Constants.BUS_DURATION[index];
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

	public static float getFullPrice(Hotel hotel,TouristAttraction attraction) {
		return getTransportCost(hotel,attraction) + attraction.getPrice();
	}

	public static float getTransportCost(Hotel hotel,TouristAttraction attraction) {
		// TODO get data in database.
		float boatCost = 0, busCost = 0;
		int index = 0;
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
		boatCost = Constants.BOAT_DURATION[index] * Transport.BOAT.getPrice();
		busCost = Constants.BUS_DURATION[index] * Transport.BUS.getPrice();
		switch (attraction.getName()) {
		case "attration1":
			return (float) (0.25 * (boatCost + busCost));
		case "attration2":
			return (float) (0.5 * (boatCost + busCost));
		case "attration3":
			return (float) (0.75 * (boatCost + busCost));
		case "attration4":
			return (float) (boatCost + busCost);
		case "attration5":
			return (float) (1.25 * (boatCost + busCost));
		}
		return 0;
	}

	public String toString() {
		return "TouristAttraction [name=" + name + ", type=" + type + ", duration=" + duration + ", price=" + price
				+ "]";
	}

}
