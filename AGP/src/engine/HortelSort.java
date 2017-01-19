package engine;

import java.util.ArrayList;
import java.util.HashMap;

import data.Hotel;
import tools.list.ListTools;
import tools.math.MathComparator;

public enum HortelSort {
	PRICE(0), RANGE(1);
	private int id;

	private HortelSort(int id) {
		this.id = id;
	}

	private static int getId(HortelSort sort) {
		return sort.id;
	}

	private static ArrayList<String> getNames(HashMap<String, Hotel> hotels) {
		ArrayList<String> names = new ArrayList<String>();
		for (String name : hotels.keySet())
			names.add(name);
		return names;
	}

	private static ArrayList<String> getNames(ArrayList<String> hotels) {
		ArrayList<String> names = new ArrayList<String>();
		for (String name : hotels)
			names.add(name);
		return names;
	}

	private static ArrayList<Double> getPrice(HashMap<String, Hotel> hotels) {
		ArrayList<Double> prices = new ArrayList<Double>();
		for (Hotel hotel : hotels.values())
			prices.add((double) hotel.getDailyPrice());
		return prices;
	}

	private static ArrayList<Double> getRange(HashMap<String, Hotel> hotels) {
		ArrayList<Double> prices = new ArrayList<Double>();
		for (Hotel hotel : hotels.values())
			prices.add((double) hotel.getRange());
		return prices;
	}

	public static ArrayList<String> sortBy(HashMap<String, Hotel> hotels, HortelSort sort) {
		ArrayList<String> names = getNames(hotels);
		switch (getId(sort)) {
		case 0:
			ListTools.sortListStringByDouble(names, getPrice(hotels));

			break;
		case 1:
			ListTools.sortListStringByDouble(names, getRange(hotels));

			break;

		default:
			break;
		}
		return names;
	}
}
