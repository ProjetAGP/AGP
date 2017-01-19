package persistence;


import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {

    static BD db;
    static ResultSet Res;

    public static void main(String[] args) throws SQLException {
        

        Parametre a = new Parametre("root", "zinebtazi", "AGP");
        
        BD db;
        ResultSet Res;
        
        db = new BD(Parametre.Host, Parametre.username, Parametre.password, Parametre.IPHOST, Parametre.Port);
        Res = db.querySelectAll("HOTEL");
        
        while (Res.next()) {
        	
        	System.out.println(Res.getString("NAME"));
        }

    }

}
