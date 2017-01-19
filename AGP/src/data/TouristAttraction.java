package data;

import data.constants.TouristAttractionType;

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

	public String toString() {
		return "TouristAttraction [name=" + name + ", type=" + type + ", duration=" + duration + ", price=" + price
				+ "]";
	}

}
