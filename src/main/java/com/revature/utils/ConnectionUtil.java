package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); 
			System.out.println("problem occurred locating driver");
		}
		
		//Kevin's environment variables go here
		
		return DriverManager.getConnection(url, username, password);
	}
}