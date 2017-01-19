package persistence;

import tools.parse.StringParseLoggable;

public class TouristicSiteData implements StringParseLoggable {

	private int id_site;
	private String name;
	private int price;
	private String type;
	private String address;
	private int longitude;
	private int lattitude;
	private int duration;
	private TouristicSiteData site = new TouristicSiteData();
	// attributAbc
	// constante : public static final int CONSTANT_A

	

	public TouristicSiteData(int i, String string, int j, String string2, String string3, int k, int l) {

	}
	public TouristicSiteData(int id_site, String name, int price, String type, String adresse, int duration,
			int longitude, int lattitude) {
		this.id_site = id_site;
		this.name = name;
		this.price = price;
		this.type = type;
		this.duration = duration;
		this.address = adresse;
		this.longitude = longitude;
		this.lattitude = lattitude;
	}

	public TouristicSiteData() {
	}

	
	
	public int getId_site() {
		return id_site;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public String getAddress() {
		return address;
	}

	public int getLongitude() {
		return longitude;
	}

	public int getLattitude() {
		return lattitude;
	}

	public int getDuration() {
		return duration;
	}

	public TouristicSiteData getSite() {
		return site;
	}

	public String toLog() {
		return name + "," + type + "," + duration + "," + price + ";";
	}

}
