package model;
import java.util.*;


public class Stanza {
	private String room_name;
	private int floor;
	private ArrayList<Sensore> l1 = new ArrayList<Sensore>();
	public enum Priority {low, medium, high}
	private Priority room_priority;
	private Map<String, Double> valori = new TreeMap<String, Double>();

	
	
	
	public Stanza() {
	}
	
	
	
	public Stanza(String room_name, int floor, ArrayList<Sensore> l1, Priority room_priority, Valori valori) {
		this.room_name = room_name;
		this.floor = floor;
		this.l1 = l1;
		this.room_priority = room_priority;
		this.valori = valori.createMap();
	}



	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_id) {
		this.room_name = room_id;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public ArrayList<Sensore> getL1() {
		return l1;
	}
	public void setL1(ArrayList<Sensore> l1) {
		this.l1 = l1;
	}
	public Priority getRoom_priority() {
		return room_priority;
	}
	public void setRoom_priority(Priority room_priority) {
		this.room_priority = room_priority;
	}
	
	
	
	public Map<String, Double> getValori() {
		return valori;
	}


	public void changeMinTemp(Double newvalore) {
		this.valori.replace("min_temp", newvalore);
	}
	
	public void changeMaxTemp(Double newvalore) {
		this.valori.replace("min_temp", newvalore);
	}
	
	public void changeMinLum(Double newvalore) {
		this.valori.replace("min_lum", newvalore);
	}
	
	public void changeMaxLum(Double newvalore) {
		this.valori.replace("max_lum", newvalore);
	}
	
	public void changeMinPres(Double newvalore) {
		this.valori.replace("min_pres", newvalore);
	}
	
	public void changeMaxPres(Double newvalore) {
		this.valori.replace("max_pres", newvalore);
	}
	
	public void changeMinHum(Double newvalore) {
		this.valori.replace("min_hum", newvalore);
	}
	
	public void changeMaxHum(Double newvalore) {
		this.valori.replace("max_hum", newvalore);
	}



	public int SensorNotWorking() {
		int count=0;
		for (Sensore S: l1) {
			if (S.getState() == 0) count++;
		}
		
		return count;
	}
	
	public List<String> typeWorking() {
		
		List<String> working = new ArrayList<String>();
		
		int temp = 0;
		int lum = 0;
		int pres = 0;
		int um = 0;
		
		for (Sensore S: l1) {
			if (S.getState() == 1) {
				if (S.getType().toString() == "temperatura") temp++;
				if (S.getType().toString() == "luminosita") lum++;
				if (S.getType().toString() == "umidita") um++;
				if (S.getType().toString() == "pressione") pres++;
			}
		}
		
		if (temp>0) working.add("temperatura");
		if (lum>0) working.add("luminosita");
		if (um>0) working.add("umidita");
		if (pres>0) working.add("pressione");
		
		return working;
		
	}
	
	
	@Override
	public String toString() {
        return " {" +
                "\"RoomName\": \"" + room_name + "\"" +
                ", \"floor\": " + floor + ", \"SensorList\": " + l1 +
                "}"; }

}
