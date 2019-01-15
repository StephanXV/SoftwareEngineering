package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDB {
	
public static boolean registraCitta(int ID,String nome,int ID_gestore) throws SQLException {
		
		
		String query = "Insert into Citta (ID,nome,ID_gestore) values(?,?,?);";

		Connection connessione = Database.connessioneDB();
		PreparedStatement cmd = connessione.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        cmd.setInt(1, ID);
		cmd.setString(2, nome);
		cmd.setInt(3,ID_gestore);
		
		cmd.executeUpdate();

		ResultSet risultato = cmd.getGeneratedKeys();

		while (risultato.next())
		{
			risultato.getInt(1);	
		}

		risultato.close();
		cmd.close();
		connessione.close();

		return true; 
	}

	public static void main(String[]args) throws SQLException {
		registraCitta(47, "L'aquila63", 13);	
	}

}
