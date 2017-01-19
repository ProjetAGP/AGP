package persistence;

public class HotelData {
	

	private int id_hotel;
	private int hrange;
    private int price;
	private String name;
	private String address;
	private int longitude;
	private int lattitude;

	public HotelData() {
	}
	
	

	public HotelData(int id_hotel, int hrange, int price, String name,
			String address, int longitude, int lattitude) {
		this.id_hotel = id_hotel;
		this.hrange = hrange;
		this.price = price;
		this.name = name;
		this.address = address;
		this.longitude = longitude;
		this.lattitude = lattitude;
	}



	public int getID_HOTEL() {
		return id_hotel;
	}

	public void setID_HOTEL(int iD_HOTEL) {
		id_hotel = iD_HOTEL;
	}

	public int getHRANGE() {
		return hrange;
	}

	public void setHRANGE(int hRANGE) {
		hrange = hRANGE;
	}

	public int getPRICE() {
		return price;
	}

	public void setPRICE(int pRICE) {
		price = pRICE;
	}

	public String getNAME() {
		return name;
	}

	public void setNAME(String nAME) {
		name = nAME;
	}

	public String getADDRESS() {
		return address;
	}

	public void setADDRESS(String aDDRESS) {
		address = aDDRESS;
	}

	public int getLONGITUDE() {
		return longitude;
	}

	public void setLONGITUDE(int lONGITUDE) {
		longitude = lONGITUDE;
	}

	public int getLATITUDE() {
		return lattitude;
	}

	public void setLATITUDE(int lATITUDE) {
		lattitude = lATITUDE;
	}

	public String toLog() {
		return name+","+hrange+","+price+";";
	}
}
