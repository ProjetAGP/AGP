package persistence;


import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {

    static DataBase db;
    static ResultSet Res;

    public static void main(String[] args) throws SQLException, IOException {
        

        Parametre a = new Parametre("root", "zinebtazi", "AGP");
        
        DataBase db;
        ResultSet Res;
        
        db = new DataBase(Parametre.Host, Parametre.username, Parametre.password, Parametre.IPHOST, Parametre.Port);
        
        Res = db.querySelectAll("hotel");
        
        while (Res.next()) {
        	
        	 Blob blob = Res.getBlob("PICTURE");
             if (blob != null) {

                 byte barr[] = blob.getBytes(1, (int) blob.length());
                 FileOutputStream fout = new FileOutputStream(Res.getString("NAME")+".jpg");
                 fout.write(barr);
             }else {
            	 
             }
        }

    }

}
