package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetBuildingName {

	public static String getName (int id_edificio) throws SQLException {
	       
		   Connection connessione = Database.connessioneDB();   
		
		   String query = "SELECT nome FROM Edificio WHERE ID=" + id_edificio;
		   PreparedStatement st;
		   ResultSet rs;
		   
		   st = connessione.prepareStatement(query);
		   rs = st.executeQuery(query);
		   
		   rs.next();
		   
		   return rs.getString("nome");
		}
	
}