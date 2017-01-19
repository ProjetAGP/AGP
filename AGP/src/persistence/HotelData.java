package persistence;

public class HotelData {
	

	private int ID_HOTEL;
	private int HRANGE;
    private int PRICE;
	private String NAME;
	private String ADDRESS;
	private int LONGITUDE;
	private int LATITUDE;

	public HotelData() {
	}
	
	

	public HotelData(int iD_HOTEL, int hRANGE, int pRICE, String nAME,
			String aDDRESS, int lONGITUDE, int lATITUDE) {
		ID_HOTEL = iD_HOTEL;
		HRANGE = hRANGE;
		PRICE = pRICE;
		NAME = nAME;
		ADDRESS = aDDRESS;
		LONGITUDE = lONGITUDE;
		LATITUDE = lATITUDE;
	}



	public int getID_HOTEL() {
		return ID_HOTEL;
	}

	public void setID_HOTEL(int iD_HOTEL) {
		ID_HOTEL = iD_HOTEL;
	}

	public int getHRANGE() {
		return HRANGE;
	}

	public void setHRANGE(int hRANGE) {
		HRANGE = hRANGE;
	}

	public int getPRICE() {
		return PRICE;
	}

	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public int getLONGITUDE() {
		return LONGITUDE;
	}

	public void setLONGITUDE(int lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}

	public int getLATITUDE() {
		return LATITUDE;
	}

	public void setLATITUDE(int lATITUDE) {
		LATITUDE = lATITUDE;
	}

	
}
