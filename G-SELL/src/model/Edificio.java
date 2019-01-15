package model;
import java.util.*;


public class Edificio {

	private String building_name;
	private List<Stanza> l2 = new ArrayList<Stanza>();
	
	public Edificio() {
	}

	public Edificio(String building_name, List<Stanza> l2) {
		this.building_name = building_name;
		this.l2 = l2;
	}

	public String getBuilding_name() {
		return building_name;
	}

	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}

	public List<Stanza> getL2() {
		return l2;
	}

	public void setL2(List<Stanza> l2) {
		this.l2 = l2;
	}
	
	@Override
	public String toString() {
        return " {" +
                "\"BuildingName\": \"" + building_name + ", \"RoomList\": " + l2 +
                "}"; }
	
	
}
