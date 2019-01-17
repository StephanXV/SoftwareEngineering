package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Sensore;
import model.Sensore.Tipo;

public class TestAdmin {
	public static boolean insertGestore(String nome, String cognome, String numero_telefono, String tipo, String username, String pass_word ) throws SQLException {
		

		String ins = "insert Utente (nome,cognome,numero_telefono,tipo,username,pass_word) values(?,?,?,?,?,?);"; 

		Connection connessione = Database.connessioneDB();
		 
		  PreparedStatement cmd = connessione.prepareStatement(ins, PreparedStatement.RETURN_GENERATED_KEYS);
		  cmd.setString(1, nome);
		  cmd.setString(2, cognome);
		  cmd.setString(3, numero_telefono);
		  cmd.setString(4,tipo);
		  cmd.setString(5, username);
		  cmd.setString(6, pass_word);
		  
		  
		  
		  cmd.executeUpdate();


		  cmd.close();

		
		
		connessione.close();

		return true; 
	}
	
	public static boolean updateAreaGestita(String TipoArea, String nome, String username) throws SQLException {
		String tipo = null;
		int id=0;
		String query = "select * from Utente where username ='" + username + "';";
		Connection connessione = Database.connessioneDB();
		
		PreparedStatement st1;
		ResultSet rs1;
		st1 = connessione.prepareStatement(query);
		rs1 = st1.executeQuery(query);
		
		while (rs1.next() == true) {
		   	tipo=rs1.getString("tipo"); 
		   	id=rs1.getInt("ID");
	   }
		
		if (TipoArea.equals(tipo)) {
		String up = "Update " + tipo + " Set ID_gestore = " + id ; 
		
		PreparedStatement cmd = connessione.prepareStatement(up);
		   
		cmd.executeUpdate();
		cmd.close(); 
		}

		
		
		connessione.close();

		return true; 
	}
	
	public static boolean updatePass(String username, String newPass) throws SQLException {
	
		String up = "Update Utente Set pass_word = '" + newPass + "' where username ='" + username + "';"; 
		Connection connessione = Database.connessioneDB();
		
		PreparedStatement cmd = connessione.prepareStatement(up);
		   
		cmd.executeUpdate();
		cmd.close(); 
		connessione.close();

		return true; 
	}
	
	

	public static void main(String[]args) throws SQLException {
		updatePass("giov31","cazzettino");	
	}
}
