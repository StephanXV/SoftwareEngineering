package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class LoginDAO {

    // verifica che username e password inseriti siano nel database e restituisce il tipo di gestore
	public static String getUser(String username, String password) {

		try {
			Connection connessione = Database.connessioneDB();
			String query = "{CALL verifica_utente(?,?)}";
			CallableStatement stmt = connessione.prepareCall(query);

			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			String tipo = null;

			while (rs.next()) {
				tipo = rs.getString("tipo");
			}

			connessione.close();

			return tipo;
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}
}
