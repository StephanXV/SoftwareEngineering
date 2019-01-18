import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.Database;
import DAO.SendingTime;
import controllers.priorityController.ExtractData;
import model.Sensore;

import model.Sensore.Tipo;

public class InvioDati {
	
 public static void main (String[] args) throws SQLException {
	int tot=2500;
	List<ExtractData> eList = new ArrayList<ExtractData>();
	Connection connessione = Database.connessioneDB();
	
	for (int i=0;i<tot;i++) {
		          
		
		ExtractData e1 = new ExtractData(i*3+(i+1), Tipo.temperatura, connessione);
		eList.add(e1);
		//eList.get(i).start();
		ExtractData e2 = new ExtractData(i*3+(i+2), Tipo.pressione, connessione);
		eList.add(e2);
		//eList.get(i+1).start();
		ExtractData e3 = new ExtractData(i*3+(i+3), Tipo.luminosita, connessione);
		eList.add(e3);
		//eList.get(i+2).start();
		ExtractData e4 = new ExtractData(i*3+(i+4), Tipo.umidita, connessione);
		eList.add(e4);
		//eList.get(i+3).start();
	}
	
	eList.parallelStream().forEach(ExtractData::start);
 }

}
