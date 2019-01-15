package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDbSelect {
	
public static boolean registraCitta() throws SQLException {
	
		
		String sql = "SELECT * FROM Citta;";
		Connection connessione = Database.connessioneDB();
		
		PreparedStatement st;
		ResultSet rs;
		
		st = connessione.prepareStatement(sql); //creo uno statement sulla connessione
		rs = st.executeQuery(sql); // faccio la query su uno statement
		
		while (rs.next() == true) {
			System.out.println(rs.getString("ID") + "\t" + rs.getString("nome"));
		}
		
		connessione.close();
		rs.close();
		st.close();

		return true;
	}

	public static void main(String[]args) throws SQLException {
		registraCitta();
		
	}


}
