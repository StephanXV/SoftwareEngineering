package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Valori;

public class TestCallQUery {
	
	public static boolean getUser (String username, String password ) throws SQLException {
		  
		  try {
		   
		   Connection connessione = Database.connessioneDB();
		   String query = "{CALL verifica_utente(?,?)}";
		   CallableStatement stmt = connessione.prepareCall(query);
		   
		   stmt.setString(1, username);
		   stmt.setString(2, password);
		   
		   ResultSet rs = stmt.executeQuery();
		   
		   
		   while (rs.next()) {
			   System.out.println(rs.getString("tipo"));
			}

		  
		   connessione.close();
		   
		   return true;
		  } catch (Exception e) {
		   return false;
		  }
		  
		  
		 }
	
	public static void main(String[]args) throws SQLException {
		getUser("ciao","iosonogay");
		
	}

}
