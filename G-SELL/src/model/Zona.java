package model;
import java.util.*;

public class Zona {
	
	private String zone_name;
	private List<Edificio> l3 = new ArrayList<Edificio>();
	
	public Zona() {
	}

	public Zona(String zone_name, List<Edificio> l3) {
		this.zone_name = zone_name;
		this.l3 = l3;
	}

	public String getZone_name() {
		return zone_name;
	}

	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}

	public List<Edificio> getL3() {
		return l3;
	}

	public void setL2(List<Edificio> l3) {
		this.l3 = l3;
	}
	
	@Override
	public String toString() {
        return " {" +
                "\"ZoneName\": \"" + zone_name + ", \"BuildingList\": " + l3 +
                "}"; }
	
	

}
