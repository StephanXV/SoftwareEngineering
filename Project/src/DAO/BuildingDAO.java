package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuildingDAO {
    public static String getEdificioMonitorato (String username) throws SQLException {

        Connection connessione = Database.connessioneDB();

        String query = "select edificio.nome as nome from edificio join utente where edificio.ID_gestore = utente.ID and\n" +
                "\t\t\t\t\t\t\t\t\t\t\tutente.username = '" + username +"'";

        PreparedStatement st;
        ResultSet rs;

        st = connessione.prepareStatement(query);
        rs = st.executeQuery(query);

        rs.next();

        return rs.getString("nome");
    }
}
