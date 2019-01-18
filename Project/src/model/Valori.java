package model;

import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import DAO.TestValoriAss;

public class Valori {
	
	private double min_temp;
	private double max_temp;
	
	private double min_lum;
	private double max_lum;
	
	private double min_pres;
	private double max_pres;
	
	private double min_hum;
	private double max_hum;
	
	private Map<String, Double> value = new TreeMap<String, Double>();
	
	public Valori() throws SQLException {
		this.min_temp = 15.0;
		this.max_temp = 23.0;
		this.min_lum = 300.0;
		this.max_lum = 800.0;
		this.min_pres = 1000.0;
		this.max_pres = 1500.0;
		this.min_hum = 30.0;
		this.max_hum = 70.0;
		TestValoriAss.registraValoriAssociati(this.min_temp, this.max_temp, this.min_lum, this.max_lum, this.min_pres, this.max_pres, this.min_hum, this.max_hum);
	}


	public Valori(double min_temp, double max_temp, double min_lum, double max_lum, double min_pres, double max_pres,
			double min_hum, double max_hum) {
		
		this.min_temp = min_temp;
		this.max_temp = max_temp;
		this.min_lum = min_lum;
		this.max_lum = max_lum;
		this.min_pres = min_pres;
		this.max_pres = max_pres;
		this.min_hum = min_hum;
		this.max_hum = max_hum;
	}


	public double getMin_temp() {
		return min_temp;
	}


	public void setMin_temp(double min_temp) {
		this.min_temp = min_temp;
	}


	public double getMax_temp() {
		return max_temp;
	}


	public void setMax_temp(double max_temp) {
		this.max_temp = max_temp;
	}


	public double getMin_lum() {
		return min_lum;
	}


	public void setMin_lum(double min_lum) {
		this.min_lum = min_lum;
	}


	public double getMax_lum() {
		return max_lum;
	}


	public void setMax_lum(double max_lum) {
		this.max_lum = max_lum;
	}


	public double getMin_pres() {
		return min_pres;
	}


	public void setMin_pres(double min_pres) {
		this.min_pres = min_pres;
	}


	public double getMax_pres() {
		return max_pres;
	}


	public void setMax_pres(double max_pres) {
		this.max_pres = max_pres;
	}


	public double getMin_hum() {
		return min_hum;
	}


	public void setMin_hum(double min_hum) {
		this.min_hum = min_hum;
	}


	public double getMax_hum() {
		return max_hum;
	}


	public void setMax_hum(double max_hum) {
		this.max_hum = max_hum;
	}

	
	public Map<String,Double> createMap(){
		value.put("min_temp", min_temp);
		value.put("max_temp", max_temp);
		value.put("min_lum", min_lum);
		value.put("max_lum", max_lum);
		value.put("min_pres", min_pres);
		value.put("max_pres", max_pres);
		value.put("min_hum", min_hum);
		value.put("max_hum", max_hum);
		
		return value;
	}

	@Override
	public String toString() {
		return "Valori [min_temp=" + min_temp + ", max_temp=" + max_temp + ", min_lum=" + min_lum + ", max_lum="
				+ max_lum + ", min_pres=" + min_pres + ", max_pres=" + max_pres + ", min_hum=" + min_hum + ", max_hum="
				+ max_hum + "]";
	}
	
	
	
	
	

}
