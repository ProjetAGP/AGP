package persistence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tools.parse.StringParser;
import data.Hotel;
import data.InputData;
import engine.OfferTools;

public class PersistenceData {

	private static List<HotelData> hotels = new ArrayList<HotelData>();
	private static List<TouristicSiteData> touristicSites = new ArrayList<TouristicSiteData>();
	private static List<TransportData> transports = new ArrayList<TransportData>();

	public static TransportData[] persisteTransport(String Etat) throws IOException {

		Parametre a = new Parametre("root", "zinebtazi", "AGP");
		DataBase db;
		ResultSet Res;
		db = new DataBase(Parametre.Host, Parametre.username, Parametre.password, Parametre.IPHOST, Parametre.Port);
		Res = db.querySelectAll("hotel", Etat);

		try {
			while (Res.next()) {

				TransportData transportData = new TransportData(Res.getInt(0), Res.getString(1), Res.getString(2), Res.getString(3), Res.getInt(4));
				transports.add(transportData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static HotelData[] persisteHotel(String Etat) throws IOException {

		Parametre a = new Parametre("root", "zinebtazi", "AGP");
		DataBase db;
		ResultSet Res;
		db = new DataBase(Parametre.Host, Parametre.username, Parametre.password, Parametre.IPHOST, Parametre.Port);
		Res = db.querySelectAll("hotel", Etat);

		try {
			while (Res.next()) {

				HotelData hotel = new HotelData(Res.getInt("ID_HOTEL"), Res.getInt("HRANGE"), Res.getInt("PRICE"),
						Res.getString("NAME"), Res.getString("ADDRESS"), Res.getInt("lONGITUDE"),
						Res.getInt("lATITUDE"));

				Blob blob = Res.getBlob("PICTURE");
				if (blob != null) {

					byte barr[] = blob.getBytes(1, (int) blob.length());
					FileOutputStream fout = new FileOutputStream(Res.getString("NAME") + ".jpg");
					System.out.println(Res.getString("NAME") + ".jpg");
					fout.write(barr);
				} else {

				}
				hotels.add(hotel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static TouristicSiteData[] persisteSite(String Etat) {

		Parametre a = new Parametre("root", "zinebtazi", "AGP");
		DataBase db;
		ResultSet Res;
		db = new DataBase(Parametre.Host, Parametre.username, Parametre.password, Parametre.IPHOST, Parametre.Port);
		Res = db.querySelectAll("TOURISTIC_SITE", Etat);

		try {
			while (Res.next()) {

				TouristicSiteData site = new TouristicSiteData(Res.getInt("ID_SITE"), Res.getString("NAME"),
						Res.getInt("PRICE"), Res.getString("TYPE"), Res.getString("ADDRESS"), Res.getInt("lONGITUDE"),
						Res.getInt("lATITUDE"));

				touristicSites.add(site);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<HotelData> getHotels() {
		return hotels;
	}

	public void removeHotels() {
		hotels.clear();
	}

	public List<TouristicSiteData> getTouristicSites() {
		return touristicSites;
	}

	public List<TransportData> getTransports() {
		return transports;
	}

}
