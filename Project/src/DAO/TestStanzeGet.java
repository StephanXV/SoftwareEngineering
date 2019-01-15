package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.sql.Connection;

import model.Stanza;
import model.Valori;

public class TestStanzeGet {
  
  public static Map<String,Integer> getStanze (String user) throws SQLException {
    String tipo=null;
    String name=null;
    int id = 0;
    int idArea = 0;
    Map<String, Integer> view = new TreeMap<String, Integer>();

    
         
    Connection connessione = Database.connessioneDB();
    
    String query1 = "SELECT * FROM Utente WHERE username = '" + user + "';";
    PreparedStatement st;
    ResultSet rs;
         
    st = connessione.prepareStatement(query1);
    rs = st.executeQuery(query1);
       
       while (rs.next() == true) {
        tipo=rs.getString("Tipo");
        id = rs.getInt("ID");
        }
       
       
    if (tipo.equals("Edificio")) { 
      String query2 = "SELECT * FROM Stanza WHERE ID_edificio = " + id + ";";
      
      PreparedStatement st1;
      ResultSet rs1;
           
      st1 = connessione.prepareStatement(query2);
      rs1 = st.executeQuery(query2);
      
      while (rs1.next() == true) {
          idArea=rs1.getInt("ID");
          name=rs1.getString("nome");
          //int pri = TestStanza.getStanza(idArea);
          //System.out.println(pri);
          //view.put(name, pri);
          }
      
      }
      
    /*else if (tipo.equals("zona")) {
      String query3 = "SELECT * FROM Edificio WHERE ID_Zona = " + id + ";";
      

      PreparedStatement st2;
      ResultSet rs2;
           
      st2 = connessione.prepareStatement(query3);
      rs2 = st.executeQuery(query3);
      
      while (rs2.next() == true) {
          idArea=rs2.getInt("ID");
          name=rs2.getString("nome");
          int pri = TestStanza.getStanza(idArea);
          view.put(name, pri);
          }
    }
    else if (tipo.equals("citta")) {}
    
    
    }
       
  }
  
  public static Map<String,Integer> edif(int id) throws SQLException {
    Connection connessione = Database.connessioneDB();
    String name=null;
    int idArea = 0;
    String query2 = "SELECT * FROM Stanza WHERE ID_edificio = " + id + ";";
    
    PreparedStatement st1;
    ResultSet rs1;
         
    st1 = connessione.prepareStatement(query2);
    rs1 = st1.executeQuery(query2);
    
    while (rs1.next() == true) {
        idArea=rs1.getInt("ID");
        name=rs1.getString("nome");
        int pri = TestStanza.getStanza(idArea);
        view.put(name, pri);
        }
  }*/
System.out.println(view);    
return view;
} 

  public static void main(String[]args) throws SQLException {
    getStanze("pavan05");
    
  }

}