package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuildingDAO {
    public static String getEdificioMonitorato (String username) throws SQLException {

        Connection connessione = Database.connessioneDB();

        String query = "select Edificio.nome as nome from Edificio join Utente where Edificio.ID_gestore = Utente.ID and\n" +
                "\t\t\t\t\t\t\t\t\t\t\tUtente.username = '" + username +"'";

        PreparedStatement st;
        ResultSet rs;

        st = connessione.prepareStatement(query);
        rs = st.executeQuery(query);

        rs.next();

        return rs.getString("nome");
    }
}
