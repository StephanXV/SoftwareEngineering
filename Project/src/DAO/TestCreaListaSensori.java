package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Stanza;
import model.Valori;
import model.Sensore.Tipo;
import model.Sensore;
import model.SensoreTabella;
import model.Stanza.Priority;

public class TestCreaListaSensori {

public static ArrayList<SensoreTabella> creaListSensori(String room_name) throws SQLException {
	//attributi stanza
	int id = 0;
	int idAss = 0;
	
	//attributi valori
	double min_temp=0.0;
	double max_temp=0.0;
	double min_lum=0.0;
	double max_lum=0.0;
	double min_pres=0.0;
	double max_pres=0.0;
	double min_hum=0.0;
	double max_hum=0.0;
	double min=0.0;
	double max=0.0;

	//attributi sensore
	String codice;
	String type;
	int stato;
	double last_data = 0;
	String anomalia = "";
	
	SensoreTabella sens1 = null;
	ArrayList<SensoreTabella> listaSens1 = new ArrayList<SensoreTabella>();


	Connection connessione = Database.connessioneDB();
		
	//prendo la stanza
	String prova = "SELECT ID,ID_valoriAssociati FROM Stanza WHERE nome= '" + room_name + "';";
	PreparedStatement st1;
	ResultSet rs1;
		 
		 
	st1 = connessione.prepareStatement(prova);
	rs1 = st1.executeQuery(prova);
		 
	while (rs1.next() == true) {
		id=rs1.getInt("ID");
		idAss=rs1.getInt("ID_ValoriAssociati");
	}
		
	//prendo i valori associati
	String query2 = "SELECT Min_ValueTemperatura, Max_ValueTemperatura, Min_ValuePressione, Max_ValuePressione, Min_ValueUmidita, Max_ValueUmidita, Min_ValueLuminosita, Max_ValueLuminosita FROM Valori_Associati WHERE ID = " + idAss;
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
	 }
		 
	//prendo i sensori
	String query3 = "SELECT * FROM Sensore WHERE ID_Stanza = " + id + ";";
		 
	PreparedStatement st2;
	ResultSet rs2;
	PreparedStatement st3;
	ResultSet rs3;
		 
	st2 = connessione.prepareStatement(query3);
	rs2 = st2.executeQuery(query3);
		 
		 
	while (rs2.next() == true) {
			  int sensor_id =rs2.getInt("ID");
			  codice=rs2.getString("codice");
			  type=rs2.getString("tipo");
			  	if (type.equals("temperatura")) {min = min_temp; max = max_temp;}
				else if (type.equals("luminosita")) {min = min_lum; max = max_lum;}
				else if (type.equals("umidita")) {min = min_hum; max = max_hum;}
				else if (type.equals("pressione")) {min = min_pres; max = max_pres;}
			  stato=rs2.getInt("stato");
			  	
			  	String query5 = "SELECT valore_percepito FROM Valore WHERE ID_Sensore = " + sensor_id + ";";
			  	st3 = connessione.prepareStatement(query5);
			  	rs3 = st3.executeQuery(query5);
				
			  	while (rs3.next() == true) {
					   last_data = rs3.getDouble("valore_percepito");

					   if (stato == 0) anomalia = "Si";
					   else if (type.equals("fumo") && (last_data == 0.0)) anomalia = "Si";
					   else if (last_data < min || last_data > max) anomalia = "Si";
					   else anomalia = "No";
			  	}
			  	
			  sens1 = new SensoreTabella (codice, type, stato, last_data, anomalia);
			  listaSens1.add(sens1);
			 
			  }
	
	return listaSens1;
		 
	}


	public static void main(String[]args) throws SQLException {
		System.out.println(creaListSensori("a1.6"));
		
	}
	
}



 
 
 
 
 
 
