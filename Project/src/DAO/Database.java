package DAO;

import java.sql.*;

public class Database {

	public static Connection connessioneDB() {
		
		Connection conn = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://db4free.net:3306/monitoraggio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "enrico1597", "Lexmark15");
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
		
		//System.out.println("Connessione al Database andata a buon fine");
		return conn;
	}

	
	}

