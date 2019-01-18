import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import controllers.priorityController.*;

import model.Sensore;
import model.Valori;
import model.Sensore.Tipo;

public class AvvioSensori {

	public static void main (String[] args) throws Exception {
		
		int i;
		int tot=37500; 
		int z=1;
		
		for (i=1;i<=tot;i++) {
		Valori valoriAss = new Valori(i);
		}
		
		System.out.println("valori_associati inseriti");
		
		DAO.InsertUtente.registraDati(826, "Lillo", "Brillo", "324567894", "Citta", "lillo05", "utente");
		
		System.out.println("utente inserito");
		
		DAO.InsertCitta.registraDati(1, "L'Aquila", 826);
		
		System.out.println("città inserita");
		
		for (i=1;i<=75;i++) {
			DAO.InsertUtente.registraDati(i+750, "Mario", "Rossi", ""+(i+750), "Zona", "utente"+(i+750), "utente");
			DAO.InsertZona.registraDati(i, "zona"+i, i+750, 1);
		}
		
		System.out.println("zone e utenti inseriti");
		z=1;
		for (i=1;i<=750;i++) {
			if (z % 10 == 0) z++;
			DAO.InsertUtente.registraDati(i, "Mario", "Rossi", ""+i, "Edificio", "utente"+i, "utente");
			DAO.InsertEdificio.registraDati(i, "edificio"+i, i, z);
		}
		
		System.out.println("edifici e utenti inseriti");	

		for (i=1;i<=tot;i++) {
			DAO.InsertStanza.registraDati(i, "stanza"+i, i % 5, i, "low", z );
			if (i % 50 == 0) z++;
		}
		
		System.out.println("stanze inseriti");
		
		for (i=0;i<tot;i++) {
			Sensore sensore1 = new Sensore(i*3+(i+1), "S"+(i*3+(i+1)), Tipo.temperatura, i+1, 1);                  
			Sensore sensore2 = new Sensore(i*3+(i+2), "S"+(i*3+(i+2)), Tipo.pressione, i+1, 1);                    
			Sensore sensore3 = new Sensore(i*3+(i+3), "S"+(i*3+(i+3)), Tipo.luminosita, i+1, 1);                   
			Sensore sensore4 = new Sensore(i*3+(i+4), "S"+(i*3+(i+4)), Tipo.umidita, i+1, 1);                      
			
		}
		
		System.out.println("sensori inseriti");
		
		
	}
	


 
}
