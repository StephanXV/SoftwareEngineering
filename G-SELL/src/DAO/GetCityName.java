package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCityName {
	
	public static String getName (int id_citta) throws SQLException {
       
	   Connection connessione = Database.connessioneDB();   
	
	   String query = "SELECT nome FROM Citta WHERE ID=" + id_citta;
	   PreparedStatement st;
	   ResultSet rs;
	   
	   st = connessione.prepareStatement(query);
	   rs = st.executeQuery(query);
	   
	   rs.next();
	   
	   return rs.getString("nome");
	}

}
