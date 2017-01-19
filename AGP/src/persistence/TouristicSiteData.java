package persistence;

public class TouristicSiteData {
	
	private int ID_SITE;
	private String NAME;
    private int PRICE;
	private String TYPE;
	private String ADDRESS;
	private int LONGITUDE;
	private int LATITUDE;
	//attributAbc
	//constante : public static final int CONSTANT_A
	
	public TouristicSiteData(){
		
	}

	public TouristicSiteData(int iD_SITE, String name, int pRICE, String tYPE,
			String aDDRESS, int lONGITUDE, int lATITUDE) {
		super();
		ID_SITE = iD_SITE;
		NAME = name;
		PRICE = pRICE;
		TYPE = tYPE;
		ADDRESS = aDDRESS;
		LONGITUDE = lONGITUDE;
		LATITUDE = lATITUDE;
	}

	public int getID_SITE() {
		return ID_SITE;
	}

	public void setID_SITE(int iD_SITE) {
		ID_SITE = iD_SITE;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public int getPRICE() {
		return PRICE;
	}

	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public int getLONGITUDE() {
		return LONGITUDE;
	}

	public void setLONGITUDE(int lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}

	public int getLATITUDE() {
		return LATITUDE;
	}

	public void setLATITUDE(int lATITUDE) {
		LATITUDE = lATITUDE;
	}


	
	
	
}
