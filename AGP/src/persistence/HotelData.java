package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelData {

	private int ID_HOTEL;
	private String NAME;
	private int PRICE;
	private int RANG;

	public HotelData() {
	}

	public HotelData(int iD_HOTEL, String nAME, int pRICE, int rANG) {
		ID_HOTEL = iD_HOTEL;
		NAME = nAME;
		PRICE = pRICE;
		RANG = rANG;
	}



	public int getID_HOTEL() {
		return ID_HOTEL;
	}

	public void setID_HOTEL(int iD_HOTEL) {
		ID_HOTEL = iD_HOTEL;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public int getPRICE() {
		return PRICE;
	}

	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}

	public int getRANG() {
		return RANG;
	}

	public void setRANG(int rANG) {
		RANG = rANG;
	}

}
