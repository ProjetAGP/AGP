package simulation;

import data.Hotel;
import data.Offer;
import data.TouristAttraction;
import data.Trip;
import data.constants.TouristAttractionType;

public class DataTest {

	public static void main(String[] args) {

		Hotel hotel1 = new Hotel("hotel1", 1, 20);
		Hotel hotel2 = new Hotel("hotel2", 3, 60);
		Hotel hotel3 = new Hotel("hotel3", 5, 100);
		
		Offer offer1 = new Offer(hotel1,2);
		Offer offer2 = new Offer(hotel2,2);
		Offer offer3 = new Offer(hotel3,2);
		
		System.out.println(hotel1);
		System.out.println(hotel2);
		System.out.println(hotel3);
		
		TouristAttraction attraction1 = new TouristAttraction("attracion1", TouristAttractionType.ACTIVITY, 30, 60);
		TouristAttraction attraction2 = new TouristAttraction("attracion1", TouristAttractionType.ACTIVITY, 50, 50);
		TouristAttraction attraction3 = new TouristAttraction("attracion1", TouristAttractionType.HISTORIC, 70, 40);
		TouristAttraction attraction4 = new TouristAttraction("attracion1", TouristAttractionType.ACTIVITY, 90, 80);
		TouristAttraction attraction5 = new TouristAttraction("attracion1", TouristAttractionType.HISTORIC, 110, 100);
		
		System.out.println(attraction1);
		System.out.println(attraction2);
		System.out.println(attraction3);
		System.out.println(attraction4);
		System.out.println(attraction5);
	
		
		Trip trip1 = new Trip();
		Trip trip2 = new Trip();
		Trip trip3 = new Trip();
		Trip trip4 = new Trip();
		Trip trip5 = new Trip();
		Trip trip6 = new Trip();
		
		trip1.addTouristAttraction(offer1.getHotel(), attraction1);
		trip1.addTouristAttraction(offer1.getHotel(), attraction2);
		trip1.addTouristAttraction(offer1.getHotel(), attraction3);
	
		trip2.addTouristAttraction(offer2.getHotel(), attraction2);
		trip2.addTouristAttraction(offer2.getHotel(), attraction3);
		trip2.addTouristAttraction(offer2.getHotel(), attraction4);
		
		trip3.addTouristAttraction(offer3.getHotel(), attraction3);
		trip3.addTouristAttraction(offer3.getHotel(), attraction4);
		trip3.addTouristAttraction(offer3.getHotel(), attraction5);
		
		trip4.addTouristAttraction(offer3.getHotel(), attraction4);
		trip4.addTouristAttraction(offer3.getHotel(), attraction5);
		trip4.addTouristAttraction(offer3.getHotel(), attraction1);
		
		trip5.addTouristAttraction(offer2.getHotel(), attraction5);
		trip5.addTouristAttraction(offer2.getHotel(), attraction1);
		trip5.addTouristAttraction(offer2.getHotel(), attraction2);
		
		trip6.addTouristAttraction(offer1.getHotel(), attraction2);
		trip6.addTouristAttraction(offer1.getHotel(), attraction5);
		trip6.addTouristAttraction(offer1.getHotel(), attraction3);
		
		offer1.addTrip(trip1);
		offer1.addTrip(trip6);
		
		offer2.addTrip(trip2);
		offer2.addTrip(trip5);
		
		offer3.addTrip(trip3);
		offer3.addTrip(trip4);

		System.out.println(offer1);
		System.out.println(offer2);
		System.out.println(offer3);
	}
	
}
