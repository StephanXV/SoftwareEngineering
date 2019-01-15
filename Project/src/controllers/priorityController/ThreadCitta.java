package controllers.priorityController;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.OptionalInt;
import java.util.TreeMap;

import DAO.CountE;
import DAO.GetCityName;
import DAO.GetZoneName;


public class ThreadCitta  {
    int count;
    int id_citta;
	Map<String, Integer> mappa_zone = new TreeMap<String,Integer>();
    public ThreadCitta (int id_citta) {
    	this.id_citta=id_citta;
    }
    
	public Map<String,Integer> run() {
	  try {
		count=CountE.conteggio(id_citta);
		  int i;
		  for (i=1; i<=count; i++) {
		     ThreadZona apri_edifici = new ThreadZona(i);
	         Map<String, Integer> mappa_edifici = apri_edifici.run();
			 int priorita_zona = Collections.max(mappa_edifici.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
	         mappa_zone.put(GetZoneName.getName(i), priorita_zona);
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return mappa_zone;

	}
}
