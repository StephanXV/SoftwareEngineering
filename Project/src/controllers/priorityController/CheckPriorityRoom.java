package controllers.priorityController;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Sensore;
import model.Stanza;



public class CheckPriorityRoom {
	
	//0= normal situation		1= low priority		2= medium priority		3= high priority		4= danger
	
	private int cont=0;

	
	public CheckPriorityRoom() {
		
	}
	
	public int priorityCheck (Stanza stanza) {
		int priorityanom=0;
		int prioritymalf=0;
		prioritymalf=this.priorityMalfunzionamenti(stanza);
		priorityanom=this.priorityAnomalia(stanza);
		return Math.max(prioritymalf, priorityanom);
	}
	
	public int priorityMalfunzionamenti(Stanza stanza) {
			int prioritymalf=0;
			int cont = stanza.SensorNotWorking();
			
			if (cont == 0) {prioritymalf=0;} //non ci sono malfunzionamenti
			
			if (cont == 1) {prioritymalf=1;} //se c'� solo un malfunzionamento
			
			if (cont > 1) {prioritymalf=2;} //se c'� solo un malfunzionamento
					
			if (stanza.typeWorking().size() < 4 && stanza.typeWorking().size()>0) {prioritymalf=3;} //c'� almeno un tipo di sensore che non rileva
			
			if (stanza.typeWorking().size()==0) {prioritymalf = 4;} //nessun tipo di sensore funziona
	        
			return prioritymalf;
	}
	
	
	public int priorityAnomalia(Stanza stanza) {
        int priorityanom=0;
        ArrayList<Sensore> lista = stanza.getL1();
        int i=0;
		for (Sensore x : lista) {
		    //if (priorityanom==4) stanza.getL1().get(i-1).getSensor_id()   setSending_time((stanza.getL1().get(i-1).getSending_time())/2);
			if (priorityanom==4) break;
			String tipo = x.getType().toString();
		
	        if (tipo.equals("luminosita")) {priorityanom=Math.max(calculatePriorityLum(x.getLast_data(), stanza),priorityanom);}
		    if (tipo.equals("pressione")) {priorityanom=Math.max(calculatePriorityPres(x.getLast_data(), stanza),priorityanom);}
		    if (tipo.equals("umidita")) {priorityanom=Math.max(calculatePriorityHum(x.getLast_data(), stanza),priorityanom);}
		    if (tipo.equals("temperatura")) {priorityanom=Math.max(calculatePriorityTemp(x.getLast_data(), stanza),priorityanom);}
		    if (tipo.equals("fumo")) {priorityanom=Math.max(calculatePrioritySmoke(x.getLast_data(), x.getState()), priorityanom);}
            i++;
		}
		return priorityanom;
	}	
	
		public int calculatePriorityLum (double value, Stanza stanza) {
			double min_lum=stanza.getValori().get("min_lum");
			double max_lum=stanza.getValori().get("max_lum");
			
			if (value <= (min_lum - 100) && value > (min_lum - 250) || value >= (max_lum + 100) && value < (max_lum + 250)) {
				cont++;
				if (cont>1) return 2;
				else return 1;
			}
			
			else if (value <= (min_lum - 250) && value > (min_lum - 500) || value >= (max_lum + 250) && value < (max_lum + 500)) return 3;
			else if (value <= (min_lum - 500) || value >= (max_lum + 500)) return 4;
			else return 0;
			
		}
		
		public int calculatePriorityHum (double value, Stanza stanza) {
			double min_hum=stanza.getValori().get("min_hum");
			double max_hum=stanza.getValori().get("max_hum");
			
			if (value <= (min_hum - 10) && value > (min_hum - 20) || value >= (max_hum + 10) && value < (max_hum + 20)) {
				cont++;
				if (cont>1) return 2;
				else return 1;
			}
			
			else if (value <= (min_hum - 20) && value > (min_hum - 30) || value >= (max_hum + 20) && value < (max_hum + 30)) return 3;
			else if (value <= (min_hum - 30) || value >= (max_hum + 30)) return 4;
			else return 0;
			
		}

		public int calculatePriorityTemp (double value, Stanza stanza) {
			double min_temp=stanza.getValori().get("min_temp");
			double max_temp=stanza.getValori().get("max_temp");
			
			if (value <= (min_temp - 2) && value > (min_temp - 5) || value >= (max_temp + 2) && value < (max_temp + 5)) {
				cont++;
				if (cont>1) return 2;
				else return 1;
			}
			
			else if (value <= (min_temp - 5) && value > (min_temp - 10) || value >= (max_temp + 5) && value < (max_temp + 10)) return 3;
			else if (value <= (min_temp - 10) || value >= (max_temp + 10)) return 4;
			else return 0;
		}

		public int calculatePriorityPres (double value, Stanza stanza) {
			double min_pres=stanza.getValori().get("min_pres");
			double max_pres=stanza.getValori().get("max_pres");
			
			if (value <= (min_pres - 50) && value > (min_pres - 100) || value >= (max_pres + 50) && value < (max_pres + 100)) {
				cont++;
				if (cont>1) return 2;
				else return 1;
			}
			
			else if (value <= (min_pres - 100) && value > (min_pres - 250) || value >= (max_pres + 100) && value < (max_pres + 250)) return 3;
			else if (value <= (min_pres - 250) || value >= (max_pres + 250)) return 4;
			else return 0;
		
		}
		
		public int calculatePrioritySmoke (double value, int state) {
            if ((int) value==1) return 4;
            if (state == 0) return 4;
            
            return 0;
		}
}
	
	
	
	
