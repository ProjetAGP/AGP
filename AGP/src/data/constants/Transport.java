package data.constants;

public enum Transport {
	BOAT(75),BUS(50);
	private float price;

	private Transport(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}
	
}
