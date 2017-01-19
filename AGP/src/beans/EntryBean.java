package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("serial")
@ManagedBean(name = "entry")
@SessionScoped
public class EntryBean implements Serializable {

	private int id;
	private int budget;
	private String touristicalSite = "Activity";
	private int confort = 1;
	private String keyWord = "keyWord";

	public String verify() {

		return "valid";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public static String toLine(EntryBean entryBean) {
		return entryBean.getBudget() + "," + entryBean.getTouristicalSite() + "," + entryBean.getKeyWord() + ","
				+ entryBean.getConfort() + ";";
	}

}
