package model;
import java.util.*;

public class Citta {
	
	private String city_name;
	private List<Zona> l4 = new ArrayList<Zona>();
	
	public Citta() {
	}

	public Citta(String city_name, List<Zona> l4) {
		this.city_name = city_name;
		this.l4 = l4;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public List<Zona> getL4() {
		return l4;
	}

	public void setL4(List<Zona> l4) {
		this.l4 = l4;
	}
	
	@Override
	public String toString() {
        return " {" +
                "\"CityName\": \"" + city_name + ", \"ZoneList\": " + l4 +
                "}"; }
	
	

}
