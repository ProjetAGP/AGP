package beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.lucene.analysis.ReusableAnalyzerBase;

import lucene.DataReader;
import lucene.LuceneTester;
import data.Hotel;
import data.InputData;
import engine.OfferTools;
import persistence.HotelData;
import persistence.TouristicSiteData;
import persistence.PersistenceData;
import tools.parse.StringParser;

@ManagedBean
@SessionScoped
public class EntryBean implements Serializable {

	private int budget;
	private String touristicalSite ="historic";
	private int confort ;
	private String keyWord="w w";

	private List<HotelData> hotels = new ArrayList<HotelData>();
	private List<TouristicSiteData> sites = new ArrayList<TouristicSiteData>();

	public String verify() throws IOException {

		InputData inputData = new InputData();
		StringParser.generateFromParse(inputData, toLine(this), ',', ';');

		hotels = OfferTools.getResquestHotel(inputData);
		sites = OfferTools.getRequestSite(inputData,keyWord);

		return "listHotel";
	}

	
	
	@Override
	public String toString() {
		return "EntryBean [budget=" + budget + ", touristicalSite="
				+ touristicalSite + ", confort=" + confort + ", keyWord="
				+ keyWord + ", hotels=" + hotels + ", sites=" + sites + "]";
	}



	public static String toLine(EntryBean bean) {
		return bean.budget + "," + bean.touristicalSite + "," + bean.keyWord
				+ "," + bean.confort + ";";
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getTouristicalSite() {
		return touristicalSite;
	}

	public void setTouristicalSite(String touristicalSite) {
		this.touristicalSite = touristicalSite;
	}

	public int getConfort() {
		return confort;
	}

	public void setConfort(int confort) {
		this.confort = confort;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public List<HotelData> getHotels() {
		return hotels;
	}

	public void setHotels(List<HotelData> hotels) {
		hotels = hotels;
	}

	public List<TouristicSiteData> getSites() {
		return sites;
	}

	public void setSites(List<TouristicSiteData> sites) {
		sites = sites;
	}

}
