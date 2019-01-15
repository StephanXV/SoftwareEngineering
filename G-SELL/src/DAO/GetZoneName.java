package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetZoneName {

	public static String getName (int id_zona) throws SQLException {
	       
		   Connection connessione = Database.connessioneDB();   
		
		   String query = "SELECT nome FROM Zona WHERE ID=" + id_zona;
		   PreparedStatement st;
		   ResultSet rs;
		   
		   st = connessione.prepareStatement(query);
		   rs = st.executeQuery(query);
		   
		   rs.next();
		   
		   return rs.getString("nome");
		}
	
}
