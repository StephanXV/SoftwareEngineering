package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SendingTime {
	
	static Connection connessione = Database.connessioneDB(); 
	
	public static void setTime(int sensor_id, long sending_time) throws SQLException {
		
		
		String query = "UPDATE Sensore SET sending_time="+sending_time+" where ID="+sensor_id;
		
		PreparedStatement st; 
		
		st = connessione.prepareStatement(query);
	    st.executeUpdate(query);
		
	}
	
	public static long getTime (int sensor_id) throws SQLException {
		
		String query = "SELECT sending_time FROM Sensore WHERE ID="+sensor_id;
		
		PreparedStatement st;
		ResultSet rs; 
		
		st = connessione.prepareStatement(query);
	    rs = st.executeQuery(query);
	    rs.next();
	    return rs.getLong("sending_time");
	    
	}

}
