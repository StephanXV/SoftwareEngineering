package model;

import java.sql.SQLException;

import DAO.SendingTime;
import DAO.TestDati;
import model.Sensore.Tipo;

public class Sensore {
	
	private int sensor_id;
	private String codice;
	public enum Tipo { temperatura, luminosita, pressione, umidita, fumo }
	private Tipo type;
	private int stanza_id;
	private int state;
	private long sending_time;
	private double last_data;
	
	
	//constructor
	public Sensore() {
	}

	public Sensore (int sensor_id, String codice, Tipo type, int stanza_id, int state) throws SQLException {
		this.sensor_id=sensor_id;
		this.codice = codice;
		this.type = type;
		this.stanza_id=stanza_id;
		this.defaultSending_time();
		this.state = state;
		Sensore.registraDati (sensor_id, codice, type, state, stanza_id, sending_time);
		//this.last_data=this.sendLast_data();
		
    }
	
	public Sensore (int sensor_id, String codice, Tipo type, int stanza_id, int state, double last_data) throws SQLException {
		this.sensor_id=sensor_id;
		this.codice = codice;
		this.type = type;
		this.stanza_id=stanza_id;
		this.state = state;
		this.defaultSending_time();
		this.last_data= last_data;
    }

	
	//getter and setter
	public int getSensor_id() {
		return sensor_id;
	}


	public void setSensor_id(int sensor_id) {
		this.sensor_id = sensor_id;
	}
	
	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Tipo getType() {
		return type;
	}

	public void setType(Tipo type) {
		
		if (this.type == Tipo.temperatura) this.sending_time = 60000;
		else if (this.type == Tipo.luminosita) this.sending_time = 300000;
		else if (this.type == Tipo.pressione) this.sending_time = 120000;
		else if (this.type == Tipo.umidita) this.sending_time = 90000;
		else if (this.type == Tipo.fumo) this.sending_time = 60000;
	}
	
	public int getStanza() {
		return stanza_id;
	}
	
	public void setStanza(int stanza_id) {
		this.stanza_id=stanza_id;
	}
	
    public double getLast_data() {
    	return this.last_data;
    }

	/*public  double sendLast_data (int id, Tipo tipo)  {
		ExtractData generadato= new ExtractData (id,tipo);
		//generadato.setName(codice);
		generadato.start();
		return last_data;
	}*/

	public void setLast_data(double last_data) {
		this.last_data = last_data;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public long getSending_time() {
		return sending_time;
	}

	public void setSending_time(long sending_time) {
		this.sending_time = sending_time;
	}
	
	public void defaultSending_time() {
		if (this.type.toString().equals("temperatura")) {this.sending_time=60000;}
		else if (this.type.toString().equals("luminosita")) {this.sending_time=300000;}
		else if (this.type.toString().equals("umidita")) {this.sending_time=90000;}
		else if (this.type.toString().equals("pressione")) {this.sending_time=120000;}
		else if (this.type.toString().equals("fumo")) {this.sending_time=60000;}
	}
	
	
	
	


	@Override
	public String toString() {
		return "Sensore [sensor_id=" + this.sensor_id + ", codice=" + this.codice + ", type=" + this.type + ", stanza= " + this.stanza_id + 
				", last_data=" + this.last_data + ", state=" + this.state + "]";
	}
	
	/*public class ExtractData extends Thread {
		 long step;
		 int id;
		 Tipo tipo;
		 double last_data;
		 public ExtractData(int id, Tipo tipo){
		  this.id=id;
		  this.tipo=tipo;
		 }
		 public void run(){
		 while (true) {
		 this.last_data=Sensore.GenerateData(tipo);
		 try {
			Sensore.push(this.last_data, this.id);
			step = SendingTime.getTime(this.id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			 System.out.println(step);
		    sleep(step);
		 } catch (Exception ex){
		 }
		 }
		 }
	}*/
	
	//sending data at regular intervals
	public static double GenerateData (Tipo type) {
		double valore = 0.0;

		
		if (type == Tipo.temperatura) valore = Math.random() * 40; //C�
		else if (type == Tipo.pressione) valore = 900 + Math.random() * 2000 ; //hPa 
		else if (type == Tipo.luminosita) valore = Math.random() * 1000; //lux 
		else if (type == Tipo.umidita) valore = Math.random() * 100; //percent 
		else if (type == Tipo.fumo) valore = Math.random() * 1; //yes no
		
		return valore;
	}
	
	public static boolean registraDati (int sensor_id, String codice, Tipo type, int state, int stanza_id, long sending_time ) throws SQLException{
		boolean risposta = TestDati.registraDati(sensor_id, codice, type.toString(), state, stanza_id, sending_time);
		return true;
	}
	

}
	
    
 

