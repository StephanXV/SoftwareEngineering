package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCreaListaSensori {

public static boolean creaListSensori(int id_stanza) throws SQLException {
	
		String prova = "SELECT ID FROM Stanza WHERE ID=" + id_stanza;
		String sql = "SELECT ID_ValoriAssociati FROM Stanza WHERE ID=(" + prova + ");";
		
		Connection connessione = Database.connessioneDB();
		
		PreparedStatement st;
		ResultSet rs;
		
		st = connessione.prepareStatement(sql); //creo uno statement sulla connessione
		rs = st.executeQuery(sql); // faccio la query su uno statement
		
		//System.out.println(sql);
		
		while (rs.next() == true) {
			System.out.println(rs.getString("ID_ValoriAssociati")); //+ "\t" + rs.getString("nome"));
		}
		
		connessione.close();
		rs.close();
		st.close();

		return true;
	}

	public static void main(String[]args) throws SQLException {
		creaListSensori(1);
		
	}
	
}
