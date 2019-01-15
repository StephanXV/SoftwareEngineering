package controllers.priorityController;

import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.TreeMap;


import DAO.GetIdCitta;
import DAO.GetIdEdificio;
import DAO.GetIdZona;

public class AggiornaCitta extends Thread {
    
	String username; 
	String tipo; 
	
	public AggiornaCitta(String username, String tipo ) {
		this.username=username;
		this.tipo=tipo;
		// TODO Auto-generated constructor stub
	}
	
	public void run () {
		while (true) {
		     int id=0;
		     Map<String, Integer> mappa = new TreeMap<String,Integer>();
		
		     if (tipo=="Citta") {
			    try {
					id=GetIdCitta.getID(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    ThreadCitta aggiorna = new ThreadCitta(id);
	            mappa = aggiorna.run();
		     }
		     if (tipo=="Zona") {
			    try {
					id=GetIdZona.getID(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    ThreadZona aggiorna = new ThreadZona(id);
			    mappa = aggiorna.run();
		     }
		     if (tipo=="Edificio") {
			    try {
					id=GetIdEdificio.getID(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    ThreadEdificio aggiorna = new ThreadEdificio(id);
			    mappa = aggiorna.run();		     
		     }
		     

		     
		 try {
			 sleep(10000);
		     for (Entry<String, Integer> entry : mappa.entrySet()) {
		         System.out.println("Nome Area: " + entry.getKey() + "; Priorità: " + entry.getValue());
		    }
		 } catch (Exception ex){
		 }
		 
	    }
	}

}
