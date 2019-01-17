package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import model.SensoreTabella;
import model.StanzaTabella;

public class TestMedia {
	
	public static StanzaTabella average (ArrayList<SensoreTabella> lista) throws SQLException {
		
		int temp=0;
		int lum=0;
		int pres=0;
		int um=0;
		double avT=0;
		double avL=0;
		double avP=0;
		double avU=0;
		
		for (SensoreTabella X : lista) {
			if (X.getTipo1().equals("temperatura")) {temp++; avT+=X.getLast_data1();}
			else if (X.getTipo1().equals("luminosita")) {lum++; avL+=X.getLast_data1();}
			else if (X.getTipo1().equals("pressione")) {pres++; avP+=X.getLast_data1();}
			else if (X.getTipo1().equals("umidita")) {um++; avU+=X.getLast_data1();}
		}
		
		avT=avT/temp;
		avL=avL/lum;
		avP=avP/pres;
		avU=avU/um;


		StanzaTabella st = new StanzaTabella(avT, avU, avP, avL);
		return st;
		

	}
}
