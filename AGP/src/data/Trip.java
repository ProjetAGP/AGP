package data;

import java.util.ArrayList;
import java.util.HashMap;

import data.constants.Constants;
import data.constants.Transport;
import engine.AttrationsTools;
import engine.TripTools;

public class Trip {
	private ArrayList<TouristAttraction> attractions = new ArrayList<TouristAttraction>();
	private HashMap<String, Transport> transports = new HashMap<String, Transport>();

	private float price = 0;

	public float getPrice(Hotel hotel) {
		if (price == 0)
			for (TouristAttraction attraction : attractions)
				price += AttrationsTools.getFullPrice(hotel, attraction, getAssociatedTransport(attraction));
				return price;
	}

	public void setPrice(float value){
		this.price = value;
	}
	
	public ArrayList<TouristAttraction> getAttractions() {
		return attractions;
	}



	public HashMap<String, Transport> getTransports() {
		return transports;
	}



	public float getPrice() {
		return price;
	}



	public Transport getAssociatedTransport(TouristAttraction touristAttraction) {
		return transports.get(touristAttraction.getName());
	}

	public boolean addAttractionAndAssocaite(TouristAttraction attraction, Hotel hotel, Transport transport) {
		if (!attractions.contains(attraction)) {
			transports.put(attraction.getName(), transport);			
			if (TripTools.getFullTime(hotel,this) + AttrationsTools.getTotalTime(hotel, attraction,
					getAssociatedTransport(attraction)) < Constants.MAX_DISPONIBLE_TIME) {
				attractions.add(attraction);
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return "Trip [attractions=" + attractions + ", transports=" + transports + ", price=" + price + "]";
	}

	

}
