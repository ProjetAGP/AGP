package data;

public class Hotel {
	private String name = "hotel";
	private int range = 0;
	private float dailyPrice = 0;
	
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
	
}
