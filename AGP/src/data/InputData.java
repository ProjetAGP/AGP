package data;

import java.util.ArrayList;

import data.constants.TouristAttractionType;
import tools.parse.StringParseGenerable;

public class InputData implements StringParseGenerable {
	private float budget;
	private TouristAttractionType type;
	private String keyWords;// format: w1 w2 w3 ...
	private int comfort;

	private InputData() {
	}

	public void generateItem(ArrayList<String> args) {
		// format: budget,siteType,key-words,comfort;
		this.budget = Float.parseFloat(args.get(0));
		this.type = args.get(1).equals("historic") ? TouristAttractionType.HISTORIC
				: TouristAttractionType.LEISURE_SITE;
		this.keyWords = args.get(2);
		this.comfort = Integer.parseInt(args.get(3));
	}

	public float getBudget() {
		return budget;
	}

	public TouristAttractionType getType() {
		return type;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public int getComfort() {
		return comfort;
	}

	public String toString() {
		return "InputData [budget=" + budget + ", type=" + type + ", keyWords=" + keyWords + ", comfort=" + comfort
				+ "]";
	}

	public String getName() {
		String typeStr = type == TouristAttractionType.HISTORIC ? "historic" : "leisure";
		return budget + typeStr + keyWords + comfort;
	}

}
