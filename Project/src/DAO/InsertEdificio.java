package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEdificio {
	
	public static boolean registraDati(int id_edificio, String nome, int id_gestore, int id_zona) throws SQLException {
		  
		  
		  String query = "Insert into Edificio (ID,nome,ID_gestore,ID_zona) values(?,?,?,?);";

		  Connection connessione = Database.connessioneDB();
		 
		  PreparedStatement cmd = connessione.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
		  cmd.setInt(1, id_edificio);
		  cmd.setString(2, nome);
		  cmd.setInt(3, id_gestore);
		  cmd.setInt(4, id_zona);
		  
		  
		  
		  cmd.executeUpdate();
          cmd.close();
		  connessione.close();
		  
		  return true;
		 }

}
