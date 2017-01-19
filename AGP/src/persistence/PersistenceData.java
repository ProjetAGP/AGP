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

	private static List<HotelData> Hotels = new ArrayList<HotelData>();
	private static List<TouristicSiteData> TouristicSites = new ArrayList<TouristicSiteData>();
	private static List<TransportData> Transports = new ArrayList<TransportData>();

	public static HotelData[] persisteHotel(String Etat) throws IOException {

		Parametre a = new Parametre("root", "zinebtazi", "AGP");
		DataBase db;
		ResultSet Res;
		db = new DataBase(Parametre.Host, Parametre.username,
				Parametre.password, Parametre.IPHOST, Parametre.Port);
		Res = db.querySelectAll("hotel", Etat);
		
		// //////////////////////////////////////////////////////////
		/*ArrayList<String> words = DataBaseTools.buildDataSet(Res);
		System.out.println(words);

		HashMap<String, Hotel> hotels2 = new HashMap<String, Hotel>();
		for (String word : words) {
			Hotel hotel2 = new Hotel();
			StringParser.generateFromParse(hotel2, word, ',', ';');
			hotels2.put(hotel2.getName(), hotel2);
		}
		System.out.println(hotels2);

		InputData inp = new InputData();
		StringParser.generateFromParse(inp, "120,historic,bal bli blu,4;", ',',
				';');
		//
		OfferTools.removeUnwantedHotels(hotels2, inp);
		System.out.println(hotels2);
		// HashMap<String, Hotel> hotels2 = StringParser.convertDataLines(new
		// Hotel(), words);*/
		// //////////////////////////////////////////////////////////////
		try {
			while (Res.next()) {

				HotelData hotel = new HotelData(Res.getInt("ID_HOTEL"),
						Res.getInt("HRANGE"), Res.getInt("PRICE"),
						Res.getString("NAME"), Res.getString("ADDRESS"),
						Res.getInt("lONGITUDE"), Res.getInt("lATITUDE"));

				Blob blob = Res.getBlob("PICTURE");
				if (blob != null) {

					byte barr[] = blob.getBytes(1, (int) blob.length());
					FileOutputStream fout = new FileOutputStream(
							Res.getString("NAME") + ".jpg");
					System.out.println(Res.getString("NAME") + ".jpg");
					fout.write(barr);
				} else {

				}
				Hotels.add(hotel);
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
		db = new DataBase(Parametre.Host, Parametre.username,
				Parametre.password, Parametre.IPHOST, Parametre.Port);
		Res = db.querySelectAll("TOURISTIC_SITE", Etat);

		try {
			while (Res.next()) {

				TouristicSiteData site = new TouristicSiteData(
						Res.getInt("ID_SITE"), Res.getString("NAME"),
						Res.getInt("PRICE"), Res.getString("TYPE"),
						Res.getString("ADDRESS"), Res.getInt("lONGITUDE"),
						Res.getInt("lATITUDE"));

				TouristicSites.add(site);
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

	public void removeHotels() {
		Hotels.clear();
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
