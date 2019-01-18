package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDati {
	
	   
	
	public static boolean registraDati(int sensor_id, String codice, String tipo, int stato, int stanza_id, long sending_time) throws SQLException {
		  
		  
		  String query = "Insert into Sensore (ID,codice,tipo,stato,ID_Stanza,sending_time) values(?,?,?,?,?,?);";
		  String query2 = "Insert into Valore (ID_Sensore,valore_percepito) values(?,?) ";

		  Connection connessione = Database.connessioneDB();
		 
		  PreparedStatement cmd = connessione.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
		  cmd.setInt(1, sensor_id);
		  cmd.setString(2, codice);
		  cmd.setString(3, tipo);
		  cmd.setInt(4,stato);
		  cmd.setInt(5, stanza_id);
		  cmd.setLong(6, sending_time);
		  
		  
		  
		  cmd.executeUpdate();


		  cmd.close();
			
		  
		  PreparedStatement cmd2 = connessione.prepareStatement(query2, PreparedStatement.RETURN_GENERATED_KEYS);
		  cmd2.setInt(1, sensor_id);
		  cmd2.setDouble(2, 0.0);
		  cmd2.executeUpdate();
		  
		  cmd2.close();
		  connessione.close();
		  
		  return true;
		 }
	
		
		public static boolean sendDati (double last_data, int sensor_id, Connection connessione) throws SQLException {
			connessione.setAutoCommit(false); 
			try {
		  

		   String query1 = "Update Valore Set valore_percepito = ?, time_stamp=current_timestamp where ID_Sensore = ?"; 
		  
		   PreparedStatement cmd = connessione.prepareStatement(query1);
		   cmd.setDouble(1, last_data);
		   cmd.setInt(2, sensor_id);
		   
		   cmd.executeUpdate();
		   cmd.close();
		   connessione.commit();
		   
		   
		   return true;
		  } catch (Exception e) {
		   return false;
		  }
			
		 }
		

}
