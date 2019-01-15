package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Valori;

public class TestValoriAss {
	
public static boolean registraValoriAssociati(double min_temp, double max_temp, double min_lum, double max_lum, double min_pres, double max_pres,
		double min_hum, double max_hum) throws SQLException {
		
		
		String query = "Insert into Valori_Associati (Min_ValueTemperatura, Max_ValueTemperatura, Min_ValuePressione, Max_ValuePressione, Min_ValueUmidita, Max_ValueUmidita, Min_ValueLuminosita, Max_ValueLuminosita) values(?,?,?,?,?,?,?,?);";

		Connection connessione = Database.connessioneDB();
		PreparedStatement cmd = connessione.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        cmd.setDouble(1, min_temp);
		cmd.setDouble(2, max_temp);
		cmd.setDouble(3, min_pres);
		cmd.setDouble(4, max_pres);
		cmd.setDouble(5, min_hum);
		cmd.setDouble(6, max_hum);
		cmd.setDouble(7, min_lum);
		cmd.setDouble(8, max_lum);
		
		cmd.executeUpdate();
		cmd.close();
		connessione.close();

		return true; 
	}

	public static void main(String[]args) throws SQLException {
		Valori valoriAss = new Valori();	
	}

}
