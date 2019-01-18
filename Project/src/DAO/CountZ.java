package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CountZ {

public static ArrayList<Integer> conteggio (int id_citta) throws SQLException {
	
	
	ArrayList<Integer> list = new ArrayList<Integer>();
	Connection connessione = Database.connessioneDB();
	String query = "CALL conta_zone ("+id_citta+")";
	
	
	CallableStatement st;
	ResultSet rs; 
	
	
    st = connessione.prepareCall(query);
    rs = st.executeQuery(query);
    while(rs.next()) {
      list.add(rs.getInt("ID"));
    }
    return list;
}

}