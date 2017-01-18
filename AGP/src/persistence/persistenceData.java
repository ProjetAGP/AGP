package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class persistenceData {
	
	private List<HotelData> Hotels = new ArrayList<HotelData>();
	private List<TouristicSiteData> TouristicSites = new ArrayList<TouristicSiteData>();
	private List<TransportData> Transports = new ArrayList<TransportData>();
	
	
	public static HotelData[] persisteHotel(String Etat) {

		Parametre a = new Parametre("root", "zinebtazi", "AGP");
		BD db;
		ResultSet Res;
		db = new BD(Parametre.Host, Parametre.username, Parametre.password,
				Parametre.IPHOST, Parametre.Port);
		Res = db.querySelectAll("HOTEL", "Etat");

		try {
			while (Res.next()) {

				System.out.println(Res.getString("NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public List<HotelData> getHotels() {
		return Hotels;
	}
	public void setHotels(List<HotelData> hotels) {
		Hotels = hotels;
	}
	public List<TouristicSiteData> getTouristicSites() {
		return TouristicSites;
	}
	public void setTouristicSites(List<TouristicSiteData> touristicSites) {
		TouristicSites = touristicSites;
	}
	public List<TransportData> getTransports() {
		return Transports;
	}
	public void setTransports(List<TransportData> transports) {
		Transports = transports;
	}
	
	

}
