package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUtente {
	
	public static boolean registraDati(int id_utente, String nome, String cognome, String numero_telefono, String tipo, String username, String password) throws SQLException {
		  
		  
		  String query = "Insert into Utente (ID,nome,cognome,numero_telefono,tipo,username,pass_word) values(?,?,?,?,?,?,?);";

		  Connection connessione = Database.connessioneDB();
		 
		  PreparedStatement cmd = connessione.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
		  cmd.setInt(1, id_utente);
		  cmd.setString(2, nome);
		  cmd.setString(3, cognome);
		  cmd.setString(4,numero_telefono);
		  cmd.setString(5, tipo);
		  cmd.setString(6, username);
		  cmd.setString(7, password);
		  
		  
		  cmd.executeUpdate();
          cmd.close();
		  connessione.close();
		  
		  return true;
		 }

}
