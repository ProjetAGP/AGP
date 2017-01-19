package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import tools.parse.StringParseGenerable;
import tools.parse.StringParser;

public class DataBaseTools {

	public static ArrayList<String> buildDataSet(ResultSet results) {
		
		ArrayList<String> lines = new ArrayList<>();
		try {
			String w = "";
			while (results.next()) {
				int i = 0;
				try {
					while (i < results.getFetchSize() - 1) {
						w = results.getString(i) + ",";
						i++;
					}
					w += results.getString(results.getFetchSize() - 1) + ";";
					lines.add(w);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lines;
	}

}
