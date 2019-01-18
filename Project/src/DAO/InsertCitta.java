package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertCitta {
	
	public static boolean registraDati(int id_citta, String nome, int id_gestore) throws SQLException {
		  
		  
		  String query = "Insert into Citta (ID,nome,ID_gestore) values(?,?,?);";

		  Connection connessione = Database.connessioneDB();
		 
		  PreparedStatement cmd = connessione.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
		  cmd.setInt(1, id_citta);
		  cmd.setString(2, nome);
		  cmd.setInt(3, id_gestore);
		  
		  
		  
		  cmd.executeUpdate();
          cmd.close();
		  connessione.close();
		  
		  return true;
		 }


}
