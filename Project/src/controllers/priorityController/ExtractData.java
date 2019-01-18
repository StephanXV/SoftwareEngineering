package controllers.priorityController;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import DAO.SendingTime;
import DAO.TestDati;
import model.Sensore;
import model.Sensore.Tipo;
	
public class ExtractData extends Thread implements Serializable {
		 long step;
		 int id;
		 Tipo tipo;
		 double last_data;
		 Connection connessione;
		 public ExtractData(int id, Tipo tipo, Connection connessione){
		  this.id=id;
		  this.tipo=tipo;
		  this.connessione=connessione;
		 }
		 public void run(){
		 while (true) {
		 this.last_data=Sensore.GenerateData(tipo);
		 //System.out.println(id+"  "+last_data);
		 try {
			ExtractData.push(this.last_data, this.id, connessione);
			step = SendingTime.getTime(this.id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			 //System.out.println(step);
		    sleep(step);
		 } catch (Exception ex){
		 }
		 }
		 }
		 
	     public static boolean push (double last_data, int sensor_id, Connection connessione) throws SQLException {
				boolean risposta = TestDati.sendDati(last_data, sensor_id, connessione);
				return true;
		}
}


