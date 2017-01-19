package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersistenceData {

	private static List<HotelData> Hotels = new ArrayList<HotelData>();
	private List<TouristicSiteData> TouristicSites = new ArrayList<TouristicSiteData>();
	private List<TransportData> Transports = new ArrayList<TransportData>();

	public static HotelData[] persisteHotel(String Etat) {

		DataBase db;
		ResultSet Res;
		db = new DataBase(Parametre.getHost(), Parametre.getUsername(), Parametre.getPassword(),
				Parametre.getIPHOST(), Parametre.getPort());
		Res = db.querySelectAll("HOTEL");

		try {
			while (Res.next()) {

				HotelData hotel = new HotelData(Res.getInt("ID_HOTEL"),
						Res.getInt("HRANGE"), Res.getInt("PRICE"),
						Res.getString("NAME"), Res.getString("ADDRESS"),
						Res.getInt("lONGITUDE"), Res.getInt("lATITUDE"));
				Hotels.add(hotel);
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
