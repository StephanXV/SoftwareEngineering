package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.Model.Valori;

public class TestUpdateValue {
	
	public static boolean updateValue(int id_stanza, String variabileAmb, double newValue) throws SQLException {
			
			
			String sql = "(select ID_ValoriAssociati from Stanza where ID =" + id_stanza + ");";
			String up = "Update valori_associati Set " + variabileAmb + " = " + newValue + " where ID = " + sql + ";"; 

			Connection connessione = Database.connessioneDB();
			
			PreparedStatement cmd = connessione.prepareStatement(up);
			   
			cmd.executeUpdate();
			cmd.close();

			
			
			connessione.close();

			return true; 
		}

		public static void main(String[]args) throws SQLException {
			updateValue(1, "Max_ValueTemperatura", 23);	
		}
	
}
