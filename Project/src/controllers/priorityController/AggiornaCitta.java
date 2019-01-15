package controllers.priorityController;

import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.TreeMap;


import DAO.GetIdCitta;
import DAO.GetIdEdificio;
import DAO.GetIdZona;

public class AggiornaCitta  {
    
	String username; 
	String tipo; 
    private Map<String, Integer> mappa = new TreeMap<String,Integer>();
	
	public AggiornaCitta(String username, String tipo ) {
		this.username=username;
		this.tipo=tipo;
		// TODO Auto-generated constructor stub
	}
	
	public Map<String,Integer> run () {
		while (true) {
		     int id=0;
		
		     if (tipo=="Citta") {
			    try {
					id=GetIdCitta.getID(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    ThreadCitta aggiorna = new ThreadCitta(id);
	            setMappa(aggiorna.run());
		     }
		     if (tipo=="Zona") {
			    try {
					id=GetIdZona.getID(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    ThreadZona aggiorna = new ThreadZona(id);
			    setMappa(aggiorna.run());
		     }
		     if (tipo=="Edificio") {
			    try {
					id=GetIdEdificio.getID(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    ThreadEdificio aggiorna = new ThreadEdificio(id);
			    setMappa(aggiorna.run());		     
		     }

		     return mappa;
		 
	    }
	}

	public Map<String, Integer> getMappa() {
		return mappa;
	}

	public void setMappa(Map<String, Integer> mappa) {
		this.mappa = mappa;
	}

}
