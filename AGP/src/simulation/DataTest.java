package simulation;

import java.util.HashMap;

import data.Hotel;
import data.Offer;
import data.TouristAttraction;
import data.Trip;
import data.constants.Transport;
import lucene.DataReader;

public class DataTest {

	public static void main(String[] args) {

		HashMap<String, Hotel> hotels = DataReader.loadHotel();
		HashMap<String, TouristAttraction> attractions = DataReader.loadSites();
		Trip trip1 = new Trip();
		Trip trip2 = new Trip();
		Trip trip3 = new Trip();		
		Offer offer = new Offer(hotels.get("hotel2"));
		
		trip1.addAttractionAndAssocaite(attractions.get("attraction1"), offer.getHotel(), Transport.BOAT);
		trip1.addAttractionAndAssocaite(attractions.get("attraction2"), offer.getHotel(), Transport.BOAT);
		System.out.println(trip1);
		trip2.addAttractionAndAssocaite(attractions.get("attraction2"), offer.getHotel(), Transport.BOAT);
		trip2.addAttractionAndAssocaite(attractions.get("attraction3"), offer.getHotel(), Transport.AUTOBUS);
		System.out.println(trip2);

		trip3.addAttractionAndAssocaite(attractions.get("attraction5"), offer.getHotel(), Transport.AUTOBUS);
		trip3.addAttractionAndAssocaite(attractions.get("attraction4"), offer.getHotel(), Transport.AUTOBUS);
		System.out.println(trip3);

		offer.addTrip(trip1);
		offer.addTrip(trip2);
		offer.addTrip(trip3);
		
		System.out.println(offer);

	}

}
