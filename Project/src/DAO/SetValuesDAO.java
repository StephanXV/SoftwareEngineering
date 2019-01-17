package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SetValuesDAO {

    public static ArrayList<String> getValoriAssociati(String stanza) {
        try {
            String query = "SELECT Min_ValueTemperatura, Max_ValueTemperatura, Min_ValueUmidita, Max_ValueUmidita,\n" +
                    "\t   Min_ValuePressione, Max_ValuePressione, Min_ValueLuminosita, Max_ValueLuminosita FROM stanza join valori_associati \n" +
                    "where stanza.ID_ValoriAssociati = valori_associati.ID and stanza.nome = '" + stanza + "';";

            Connection connessione = Database.connessioneDB();
            PreparedStatement cmd = connessione.prepareStatement(query);
            ResultSet rs;
            rs = cmd.executeQuery(query);
            ArrayList<String> list = new ArrayList<String>();
            rs.next();
            list.add(rs.getString("Min_ValueTemperatura"));
            list.add(rs.getString("Max_ValueTemperatura"));
            list.add(rs.getString("Min_ValueUmidita"));
            list.add(rs.getString("Max_ValueUmidita"));
            list.add(rs.getString("Min_ValuePressione"));
            list.add(rs.getString("Max_ValuePressione"));
            list.add(rs.getString("Min_ValueLuminosita"));
            list.add(rs.getString("Max_ValueLuminosita"));

            cmd.close();
            connessione.close();
            return list;
        } catch (Exception ex) {
            ex.getStackTrace();
            return null;
        }
    }
}

