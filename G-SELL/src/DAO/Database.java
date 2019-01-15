package DAO;

import java.sql.*;

public class Database {

	public static Connection connessioneDB() {
		
		Connection conn = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/Monitoraggio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "08061997");
		}
		catch (SQLException ex)
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("ERROR:" + ex.getErrorCode());
			ex.printStackTrace();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		System.out.println("Connessione al Database andata a buon fine");
		return conn;
	}

	
	}

