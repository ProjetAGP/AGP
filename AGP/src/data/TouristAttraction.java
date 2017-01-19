package data;

import java.util.ArrayList;

import data.constants.TouristAttractionType;
import tools.parse.StringParseGenerable;

public class TouristAttraction implements StringParseGenerable {

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

	public TouristAttraction() {
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

	public void generateItem(ArrayList<String> args) {
		this.name = args.get(0);
		this.type = args.get(1).equals("historic") ? TouristAttractionType.HISTORIC
				: TouristAttractionType.LEISURE_SITE;
		this.duration = Integer.parseInt(args.get(2));
		this.price = Float.parseFloat(args.get(3));
	}

}
