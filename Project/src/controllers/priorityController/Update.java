package controllers.priorityController;

import java.sql.SQLException;
import java.util.Map;

import DAO.TestStanza;
import model.Stanza;

public class Update  {
	 private int step;
	 private int priorita1;
	 private int id_stanza;
	 private String room_name;
	 private Stanza stanza;
	 
	 
	 public Update(int id_stanza) throws SQLException {
	    this.id_stanza=id_stanza;
	    stanza=TestStanza.getStanza(this.id_stanza);
	    CheckPriorityRoom priorita = new CheckPriorityRoom(); 
	    priorita1 = priorita.priorityCheck(stanza);
        room_name=stanza.getRoom_name();
        System.out.println("La priorità della " + stanza.getRoom_name() + " è "+getPriorita1());

	 }
	 


	public int getPriorita1() {
		return priorita1;
	}

	public void setPriorita1(int priorita1) {
		this.priorita1 = priorita1;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	 

	
}