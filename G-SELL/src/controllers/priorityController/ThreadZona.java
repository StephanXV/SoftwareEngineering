package controllers.priorityController;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.TreeMap;

import DAO.CountE;
import DAO.GetBuildingName;
import DAO.GetZoneName;


public class ThreadZona {
    int count;
    int id_zona;
    Map<String, Integer> mappa_edifici = new TreeMap<String,Integer>();
	private int priorita_zona;
    
    public ThreadZona (int id_zona) {
    	this.id_zona=id_zona;
    }
    
	public Map<String,Integer> run() {
	  try {
		count=CountE.conteggio(id_zona);
		  int i;
		  for (i=1; i<=count; i++) {
		     ThreadEdificio apri_stanze = new ThreadEdificio(i);
	         Map<String, Integer> mappa_stanze = apri_stanze.run();
	         int priorita_edificio = Collections.max(mappa_stanze.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
	         mappa_edifici.put(GetBuildingName.getName(i), priorita_edificio);
		  }

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return mappa_edifici;

	}

	public Integer getPriorita_zona() {
		return priorita_zona;
	}

	public void setPriorita_zona(int priorita_zona) {
		this.priorita_zona = priorita_zona;
	}
}
