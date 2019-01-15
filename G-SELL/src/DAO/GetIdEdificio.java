package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetIdEdificio {

	public static int getID (String username) throws SQLException {
		
		int count;
		
		Connection connessione = Database.connessioneDB();
		String query = "CALL getIdEdificio ("+"'"+username+"'"+")";
		
		
		CallableStatement st;
		ResultSet rs; 
		
		
	    st = connessione.prepareCall(query);
	    rs = st.executeQuery(query);
	    rs.next();
	    count = rs.getInt("ID");
	    return count;
	}
}
