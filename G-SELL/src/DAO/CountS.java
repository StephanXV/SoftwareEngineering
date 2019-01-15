package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountS {

public static int conteggio (int id_edificio) throws SQLException {
	
	int count;
	
	Connection connessione = Database.connessioneDB();
	String query = "CALL conta_stanze ("+id_edificio+")";
	
	
	CallableStatement st;
	ResultSet rs; 
	
	
    st = connessione.prepareCall(query);
    rs = st.executeQuery(query);
    rs.next();
    count = rs.getInt("COUNT(*)");
    return count;
}

}
