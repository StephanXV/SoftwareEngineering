package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountZ {

public static int conteggio (int id_citta) throws SQLException {
	
	int count;
	
	Connection connessione = Database.connessioneDB();
	String query = "CALL conta_zone ("+id_citta+")";
	
	
	CallableStatement st;
	ResultSet rs; 
	
	
    st = connessione.prepareCall(query);
    rs = st.executeQuery(query);
    rs.next();
    count = rs.getInt("COUNT(*)");
    return count;
}

}