package beans;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistence.BD;
import persistence.Parametre;

@ManagedBean(name = "entry")
@SessionScoped
public class EntryBean implements Serializable {

	private int id;
	private int budget;
	private String TouristicalSite = "Activity";
	private int confort = 1;

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
		return TouristicalSite;
	}

	public void setTouristicalSite(String touristicalSite) {
		TouristicalSite = touristicalSite;
	}

	public int getConfort() {
		return confort;
	}

	public void setConfort(int confort) {
		this.confort = confort;
	}
	

}
