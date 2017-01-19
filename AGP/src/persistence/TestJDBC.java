package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {



	public static void main(String[] args) throws SQLException {

		DataBase db;
		ResultSet Res;

		db = new DataBase(Parametre.getHost(), Parametre.getUsername(), Parametre.getPassword(), Parametre.getIPHOST(), Parametre.getPort());
		Res = db.querySelectAll("HOTEL");

		while (Res.next()) {

			System.out.println(Res.getString("NAME"));
		}

	}

}
