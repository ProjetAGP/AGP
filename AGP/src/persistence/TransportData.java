package persistence;

import tools.parse.StringParseLoggable;

public class TransportData implements StringParseLoggable {

	private String hotelName;
	private String attractionName;
	private String transport;
	private int duration;

	public TransportData(String hotelName, String attractionName, String transport, int duration) {
		this.hotelName = hotelName;
		this.attractionName = attractionName;
		this.transport = transport;
		this.duration = duration;
	}

	public String toLog() {
		return hotelName + "," + attractionName + "," + transport + "," + duration + ";";
	}

	public String getHotelName() {
		return hotelName;
	}

	public String getAttractionName() {
		return attractionName;
	}

	public String getTransport() {
		return transport;
	}

	public int getDuration() {
		return duration;
	}

	public String toString() {
		return "TransportData [hotelName=" + hotelName + ", attractionName=" + attractionName + ", transport="
				+ transport + ", duration=" + duration + "]";
	}

}
