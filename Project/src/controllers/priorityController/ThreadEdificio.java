package controllers.priorityController;

import java.sql.SQLException;
import java.util.Map;
import java.util.OptionalInt;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import DAO.CountS;


public class ThreadEdificio {
	   ArrayList<Integer> list = new ArrayList<Integer>();
       int id_edificio;
	   Map<String, Integer> mappa_stanze = new TreeMap<String,Integer>();
	   int priorita_edificio;
       
	   public ThreadEdificio (int id_edificio) {
    	  this.id_edificio=id_edificio;
       }
    
	   public Map<String,Integer> run() {
	      try {
		     list=DAO.CountS.conteggio(id_edificio);
		  for (Integer i : list) {
		     Update aggiorna = new Update(i);
	         mappa_stanze.put(aggiorna.getRoom_name(), aggiorna.getPriorita1());
		  }


	   } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	     }
	      
	      return mappa_stanze;

	   }

	public int getPriorita_edificio() {
		return priorita_edificio;
	}

	public void setPriorita_edificio(int priorita_edificio) {
		this.priorita_edificio = priorita_edificio;
	}
	   
}





