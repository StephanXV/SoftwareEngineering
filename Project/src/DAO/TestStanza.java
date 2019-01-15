package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.Valori;
import controllers.priorityController.CheckPriorityRoom;
import model.Sensore;
import model.Sensore.Tipo;
import model.Stanza;
import model.Stanza.Priority;


public class TestStanza {
	
	public static Stanza getStanza (int id_stanza) throws SQLException {
		  
		//attributo stanza
		  String room_name;
		  int floor;
		  ArrayList<Sensore> listaSens = new ArrayList<Sensore>();
		  String priority;
		  Map<String, Double> valoriAs = new TreeMap<String, Double>();
		  Stanza stanza = null;
		  
		//attributi valori
		  double min_temp;
		  double max_temp;
		  double min_lum;
		  double max_lum;
		  double min_pres;
		  double max_pres;
		  double min_hum;
		  double max_hum;
		  Valori valori = null;
		  
		//attributi sensore
		  int sensor_id;
		  String codice;
		  String type;
		  int stanza_id;
		  int state;
		  double last_data = 0;
		  Sensore sens = null;
		  
		  
		  try {
		   
			  
		   Connection connessione = Database.connessioneDB();

		   //creo i valori associati
		   String query1 = "SELECT ID_ValoriAssociati FROM Stanza WHERE ID = " + id_stanza;
		   String query2 = "SELECT Min_ValueTemperatura, Max_ValueTemperatura, Min_ValuePressione, Max_ValuePressione, Min_ValueUmidita, Max_ValueUmidita, Min_ValueLuminosita, Max_ValueLuminosita FROM Valori_Associati WHERE ID = (" + query1 + ") ;";
	

		   
		   PreparedStatement st;
		   ResultSet rs;
		   
		   
		   st = connessione.prepareStatement(query2);
		   rs = st.executeQuery(query2);
		   
		   while (rs.next() == true) {
		    min_temp=rs.getDouble("Min_ValueTemperatura");
		    max_temp=rs.getDouble("Max_ValueTemperatura");
		    min_lum=rs.getDouble("Min_ValueLuminosita");
		    max_lum=rs.getDouble("Max_ValueLuminosita");
		    min_pres=rs.getDouble("Min_ValuePressione");
		    max_pres=rs.getDouble("Max_ValuePressione");
		    min_hum=rs.getDouble("Min_ValueUmidita");
		    max_hum=rs.getDouble("Max_ValueUmidita"); 
		    valori = new Valori (min_temp,max_temp,min_lum,max_lum,min_pres,max_pres,min_hum,max_hum); }
		   
		   //System.out.println();
		   //System.out.println(valori);
		   
		   
		   
		   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		   //creo i sensori e la lista di sensori la assegno alla stanza
		   String query3 = "SELECT ID,codice,tipo,stato,ID_Stanza FROM Sensore WHERE ID_Stanza = " + id_stanza + ";";
		   
		   PreparedStatement st1;
		   ResultSet rs1;
		   PreparedStatement st3;
		   ResultSet rs3;
		   
		   st1 = connessione.prepareStatement(query3);
		   rs1 = st1.executeQuery(query3);
		   
		   Tipo tipo;
		   
		   
		   
		   
		   
		   while (rs1.next() == true) {
			   	sensor_id=rs1.getInt("ID");
			    codice=rs1.getString("codice");
			    state=rs1.getInt("stato");
			    stanza_id=rs1.getInt("ID_Stanza");
			    type=rs1.getString("tipo");
			    tipo = Tipo.valueOf(type);
			    
			    String query5 = "SELECT valore_percepito FROM Valore WHERE ID_Sensore = " + sensor_id + ";";
			    st3 = connessione.prepareStatement(query5);
				rs3 = st3.executeQuery(query5);
				while (rs3.next() == true) {
					   last_data = rs3.getDouble("valore_percepito");   
				   }
			    
			  
			   sens = new Sensore (sensor_id, codice, tipo, stanza_id, state, last_data);
			   listaSens.add(sens); 
			   
			    
		   }
		   
		   //System.out.println("a");
		   //System.out.println();
		   //System.out.println(listaSens);
		   
		   
		   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			  //creo la stanza e gli assegno i valori associati
			   String query4 = "SELECT * FROM Stanza WHERE ID=" + id_stanza;
			   PreparedStatement st2;
			   ResultSet rs2;
			   
			   st2 = connessione.prepareStatement(query4);
			   rs2 = st2.executeQuery(query4);
			   Priority pr;
			   
			   while (rs2.next() == true) {
				   	room_name=rs2.getString("nome");
				    floor=rs2.getInt("piano");
				    priority=rs2.getString("priorita"); //da mettere nel db
				    pr = Priority.valueOf(priority);
				    
				    stanza = new Stanza (room_name, floor, listaSens, pr, valori);
				       
			   }
			   
			   //System.out.println();
			   //System.out.println(stanza); 
			   
			   /*CheckPriorityRoom priorita = new CheckPriorityRoom(); 
			   int priorita1=priorita.priorityCheck(stanza);
			   System.out.println();
			   System.out.println(stanza.getL1().get(0).toString());
				System.out.println(stanza.getL1().get(1).toString());
				System.out.println(stanza.getL1().get(2).toString());
				System.out.println(stanza.getL1().get(3).toString());
				System.out.println(stanza.getL1().get(4).toString());
				System.out.println();
		        System.out.println("La priorit� della " + stanza.getRoom_name() + " � "+priorita1);*/
		        
		        //System.out.println();
			    average(listaSens);
		  
		   connessione.close();
		   
		   return stanza;
		  } catch (Exception e) {
		   return stanza;
		  }
		  
		  
		 }
	
	/*public static void main(String[]args) throws SQLException {
		getStanza(1);
		
	}*/
	
	public static void average (List <Sensore> lista) throws SQLException {
		
		int temp=0;
		int lum=0;
		int pres=0;
		int um=0;
		double avT=0;
		double avL=0;
		double avP=0;
		double avU=0;
		
		for (Sensore X : lista) {
			if (X.getType().toString().equals("temperatura")) {temp++; avT+=X.getLast_data();}
			else if (X.getType().toString().equals("luminosita")) {lum++; avL+=X.getLast_data();}
			else if (X.getType().toString().equals("pressione")) {pres++; avP+=X.getLast_data();}
			else if (X.getType().toString().equals("umidita")) {um++; avU+=X.getLast_data();}
		}
		
		//System.out.println("MEDIA VALORI: temperatura=" + avT/temp + ";   luminosit�:" + avL/lum + ";   pressione:" + avP/pres + ";   umidit�:" + avU/um);
		//return ("MEDIA VALORI: temperatura=" + avT/temp + ";   luminosit�:" + avL/lum + ";   pressione:" + avP/pres + ";   umidit�:" + avU/um);
	}

}
