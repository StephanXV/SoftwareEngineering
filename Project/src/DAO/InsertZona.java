package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertZona {
	
	public static boolean registraDati(int id_zona, String nome, int id_gestore, int id_citta) throws SQLException {
		  
		  
		  String query = "Insert into Zona (ID,nome,ID_gestore,ID_citta) values(?,?,?,?);";

		  Connection connessione = Database.connessioneDB();
		 
		  PreparedStatement cmd = connessione.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
		  cmd.setInt(1, id_zona);
		  cmd.setString(2, nome);
		  cmd.setInt(3, id_gestore);
		  cmd.setInt(4, id_citta);
		  
		  
		  
		  cmd.executeUpdate();
          cmd.close();
		  connessione.close();
		  
		  return true;
		 }


}
