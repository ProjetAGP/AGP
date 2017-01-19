package data;

import java.util.ArrayList;

import tools.parse.StringParseGenerable;

public class Hotel implements StringParseGenerable {
	private String name = "hotel";
	private int range = 0;
	private float dailyPrice = 0;
	public Hotel(){};
	public Hotel(String name, int range, float dailyPrice) {
		this.name = name;
		this.range = range;
		this.dailyPrice = dailyPrice;
	}

	public String getName() {
		return name;
	}

	public int getRange() {
		return range;
	}

	public float getDailyPrice() {
		return dailyPrice;
	}

	public String toString() {
		return "Hotel [name=" + name + ", range=" + range + ", dailyPrice=" + dailyPrice + "]";
	}
	
	public void generateItem(ArrayList<String> args) {
		this.name = args.get(0);
		this.range = Integer.parseInt(args.get(1));
		this.dailyPrice = Float.parseFloat(args.get(2));
	}
	
}
