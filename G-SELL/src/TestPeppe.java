import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import controllers.priorityController.AggiornaCitta;
import controllers.priorityController.CheckPriorityRoom;
import controllers.priorityController.ThreadCitta;
import controllers.priorityController.Update;
import DAO.CountS;
import model.Sensore;
import model.Sensore.Tipo;
import model.Stanza;
import model.Stanza.Priority;
import model.Valori;

public class TestPeppe {

	public static void main (String[] args) throws Exception {
		
        int count;
		
		Sensore sensore1 = new Sensore(1, "T1", Tipo.temperatura, 1, 1);
		Sensore sensore2 = new Sensore(2, "P1", Tipo.pressione, 1, 1);
		Sensore sensore3 = new Sensore(3, "L1", Tipo.luminosita, 1, 1);
		Sensore sensore4 = new Sensore(4, "T2", Tipo.temperatura, 1, 1);
		Sensore sensore5 = new Sensore(5, "U2", Tipo.umidita, 1, 1);
		Sensore sensore6 = new Sensore(6, "T12", Tipo.temperatura, 2, 1);
		Sensore sensore7 = new Sensore(7, "P12", Tipo.pressione, 2, 1);
		Sensore sensore8 = new Sensore(8, "L12", Tipo.luminosita, 2, 1);
		Sensore sensore9 = new Sensore(9, "T22", Tipo.temperatura, 2, 1);
		Sensore sensore10 = new Sensore(10, "U22", Tipo.umidita, 2, 1);
		Sensore sensore11 = new Sensore(11, "T13", Tipo.temperatura, 3, 1);
		Sensore sensore12 = new Sensore(12, "P13", Tipo.pressione, 3, 1);
		Sensore sensore13 = new Sensore(13, "L13", Tipo.luminosita, 3, 1);
		Sensore sensore14 = new Sensore(14, "T23", Tipo.temperatura, 3, 1);
		Sensore sensore15 = new Sensore(15, "U23", Tipo.umidita, 3, 1);
		Sensore sensore16 = new Sensore(16, "T14", Tipo.temperatura, 4, 1);
		Sensore sensore17 = new Sensore(17, "P14", Tipo.pressione, 4, 1);
		Sensore sensore18 = new Sensore(18, "L14", Tipo.luminosita, 4, 1);
		Sensore sensore19 = new Sensore(19, "T24", Tipo.temperatura, 4, 1);
		Sensore sensore20 = new Sensore(20, "U24", Tipo.umidita, 4, 1);
		Sensore sensore21 = new Sensore(21, "T15", Tipo.temperatura, 5, 1);
		Sensore sensore22 = new Sensore(22, "P15", Tipo.pressione, 5, 1);
		Sensore sensore23 = new Sensore(23, "L15", Tipo.luminosita, 5, 1);
		Sensore sensore24 = new Sensore(24, "T25", Tipo.temperatura, 5, 1);
		Sensore sensore25 = new Sensore(25, "U25", Tipo.umidita, 5, 1);
		Sensore sensore26 = new Sensore(26, "T16", Tipo.temperatura, 6, 1);
		Sensore sensore27 = new Sensore(27, "P16", Tipo.pressione, 6, 1);
		Sensore sensore28 = new Sensore(28, "L16", Tipo.luminosita, 6, 1);
		Sensore sensore29 = new Sensore(29, "T26", Tipo.temperatura, 6, 1);
		Sensore sensore30 = new Sensore(30, "U26", Tipo.umidita, 6, 1);
		Sensore sensore31 = new Sensore(31, "T17", Tipo.temperatura, 7, 1);
		Sensore sensore32 = new Sensore(32, "P17", Tipo.pressione, 7, 1);
		Sensore sensore33 = new Sensore(33, "L17", Tipo.luminosita, 7, 1);
		Sensore sensore34 = new Sensore(34, "T27", Tipo.temperatura, 7, 1);
		Sensore sensore35 = new Sensore(35, "U27", Tipo.umidita, 7, 1);
		Sensore sensore36 = new Sensore(36, "T18", Tipo.temperatura, 8, 1);
		Sensore sensore37 = new Sensore(37, "P18", Tipo.pressione, 8, 1);
		Sensore sensore38 = new Sensore(38, "L18", Tipo.luminosita, 8, 1);
		Sensore sensore39 = new Sensore(39, "T28", Tipo.temperatura, 8, 1);
		Sensore sensore40 = new Sensore(40, "U28", Tipo.umidita, 8, 1);
		Sensore sensore41 = new Sensore(41, "T19", Tipo.temperatura, 9, 1);
		Sensore sensore42 = new Sensore(42, "P19", Tipo.pressione, 9, 1);
		Sensore sensore43 = new Sensore(43, "L19", Tipo.luminosita, 9, 1);
		Sensore sensore44 = new Sensore(44, "T29", Tipo.temperatura, 9, 1);
		Sensore sensore45 = new Sensore(45, "U29", Tipo.umidita, 9, 1);
		Sensore sensore46 = new Sensore(46, "T110", Tipo.temperatura, 10, 1);
		Sensore sensore47 = new Sensore(47, "P110", Tipo.pressione, 10, 1);
		Sensore sensore48 = new Sensore(48, "L110", Tipo.luminosita, 10, 1);
		Sensore sensore49 = new Sensore(49, "T210", Tipo.temperatura, 10, 1);
		Sensore sensore50 = new Sensore(50, "U210", Tipo.umidita, 10, 1);
		
        


        AggiornaCitta update = new AggiornaCitta("iala05", "Citta");
        update.run();

		
		/*List<Sensore> stanza = new ArrayList<Sensore>();
		stanza.add(sensore1);
		stanza.add(sensore2);
		stanza.add(sensore3);
		stanza.add(sensore4);
		stanza.add(sensore5);
		
		Valori valori = new Valori();
		
		Stanza stanza1 = new Stanza("stanza1", 1, stanza, Priority.low, valori);
		
        Update aggiorna = new Update(6000, stanza1);
        aggiorna.start();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        do {
        	input = reader.readLine();
        	System.out.println("eco: "+input);
        } while (!input.equals("exit"));
        	System.exit(0);*/
	}
	


    
}
