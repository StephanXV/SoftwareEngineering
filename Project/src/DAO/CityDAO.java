package DAO;

import java.sql.*;

public class CityDAO {
    public static String getCittaMonitorata (String username) throws SQLException {

        Connection connessione = Database.connessioneDB();

        String query = "select Citta.nome as nome from Citta join Utente where Citta.ID_gestore = Utente.ID and\n" +
                "\t\t\t\t\t\t\t\t\t\t\tUtente.username = '" + username +"'";

        PreparedStatement st;
        ResultSet rs;

        st = connessione.prepareStatement(query);
        rs = st.executeQuery(query);

        rs.next();

        return rs.getString("nome");
    }

    public static Double avg_zona_temp(String zona) {

        Double avg_temp = 0.00;

        try {
            Connection connessione = Database.connessioneDB();
            String query = "{CALL avg_zona_temp(?)}";
            CallableStatement stmt = connessione.prepareCall(query);

            stmt.setString(1, zona);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                avg_temp = rs.getDouble("avg_temp");
            }

            connessione.close();

            return avg_temp;
        } catch (Exception ex) {
            ex.printStackTrace();
            return avg_temp;
        }
    }

    public static Double avg_zona_um(String zona) {

        Double avg_um = 0.00;

        try {
            Connection connessione = Database.connessioneDB();
            String query = "{CALL avg_zona_um(?)}";
            CallableStatement stmt = connessione.prepareCall(query);

            stmt.setString(1, zona);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                avg_um = rs.getDouble("avg_um");
            }

            connessione.close();

            return avg_um;
        } catch (Exception ex) {
            ex.printStackTrace();
            return avg_um;
        }
    }

    public static Double avg_zona_pres(String zona) {

        Double avg_pres = 0.00;

        try {
            Connection connessione = Database.connessioneDB();
            String query = "{CALL avg_zona_pres(?)}";
            CallableStatement stmt = connessione.prepareCall(query);

            stmt.setString(1, zona);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                avg_pres = rs.getDouble("avg_pres");
            }

            connessione.close();

            return avg_pres;
        } catch (Exception ex) {
            ex.printStackTrace();
            return avg_pres;
        }
    }

    public static Double avg_zona_lum(String zona) {

        Double avg_lum = 0.00;

        try {
            Connection connessione = Database.connessioneDB();
            String query = "{CALL avg_zona_lum(?)}";
            CallableStatement stmt = connessione.prepareCall(query);

            stmt.setString(1, zona);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                avg_lum = rs.getDouble("avg_lum");
            }

            connessione.close();

            return avg_lum;
        } catch (Exception ex) {
            ex.printStackTrace();
            return avg_lum;
        }
    }
}
