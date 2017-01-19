package data.constants;

public class Constants {
	
	public static final String SIM_DATA_PATH = "./AGP/src/simulation/simdata";
	public static final String TIMES_FILE = SIM_DATA_PATH+"/times.txt"; 
	public static final int[] BUS_DURATION = new int[]{30,0,0,20,10,5}; 
	public static final int[] BOAT_DURATION = new int[]{0,15,45,25,20,15};
	public static final int MINUTES_IN_DAY = 1440;
	public static final int MAX_DISPONIBLE_TIME = 960;
	public static final int COMFORT_REGULATION = 150;
	public static final String HOTELS_FILE = SIM_DATA_PATH+"/hotel.txt";
	public static final String SITES_FILE = SIM_DATA_PATH+"/sites.txt";
	
}
