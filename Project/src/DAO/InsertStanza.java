package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Stanza;

public class InsertStanza {
	
	public static boolean registraDati(int id_stanza, String nome, int piano, int valori_ass, String priorita, int id_edificio) throws SQLException {
		  
		  
		  String query = "Insert into Stanza (ID,nome,piano,ID_ValoriAssociati,priorita,ID_edificio) values(?,?,?,?,?,?);";

		  Connection connessione = Database.connessioneDB();
		 
		  PreparedStatement cmd = connessione.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
		  cmd.setInt(1, id_stanza);
		  cmd.setString(2, nome);
		  cmd.setInt(3, piano);
		  cmd.setInt(4,valori_ass);
		  cmd.setString(5, priorita);
		  cmd.setLong(6, id_edificio);
		  
		  
		  
		  cmd.executeUpdate();
          cmd.close();
		  connessione.close();
		  
		  return true;
		 }

}
