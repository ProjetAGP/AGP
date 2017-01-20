package data;

import java.util.ArrayList;

import data.constants.Transport;
import tools.parse.StringParseGenerable;

public class TransportRoad implements StringParseGenerable{
	
	private String hotelName;
	private String attractionName;
	private Transport transport;
	private int duration;
	public TransportRoad(String hotelName, String attractionName, Transport transport, int duration) {
		super();
		this.hotelName = hotelName;
		this.attractionName = attractionName;
		this.transport = transport;
		this.duration = duration;
	}
	public String getHotelName() {
		return hotelName;
	}
	public String getAttractionName() {
		return attractionName;
	}
	public Transport getTransport() {
		return transport;
	}
	public int getDuration() {
		return duration;
	}
	
	public String toString() {
		return "TransportRoad [hotelName=" + hotelName + ", attractionName=" + attractionName + ", transport="
				+ transport + ", duration=" + duration + "]";
	}
	public void generateItem(ArrayList<String> args) {
		this.hotelName = args.get(0);
		this.attractionName = args.get(1);
		this.transport = args.get(1).equals("autobus") ? Transport.AUTOBUS : Transport.BOAT;
	}
	
	public String getName() {
		String tra = transport == Transport.AUTOBUS ? "autobus" : "boat";
		return hotelName+","+attractionName+","+tra+","+duration;
	}
	
	
	
}
