package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Valori;

public class TestUpdateValue {
	
	public static boolean updateValue(String nomeStanza, String variabileAmb, double newValue) throws SQLException {
			
			
			String sql = "(select ID_ValoriAssociati from Stanza where nome = '" + nomeStanza + "');";
			String up = "Update Valori_Associati Set " + variabileAmb + " = " + newValue + " where ID = " + sql + ";"; 

			Connection connessione = Database.connessioneDB();
			
			PreparedStatement cmd = connessione.prepareStatement(up);
			   
			cmd.executeUpdate();
			cmd.close();

			
			
			connessione.close();

			return true; 
		}

		public static void main(String[]args) throws SQLException {
			updateValue("Pippo", "Max_ValueTemperatura", 23);
		}
	
}
