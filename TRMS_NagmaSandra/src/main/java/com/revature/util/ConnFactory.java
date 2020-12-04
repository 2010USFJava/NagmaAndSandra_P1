package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static ConnFactory cf;
	
	private ConnFactory() {
		super();
	}
	
	public static synchronized ConnFactory getInstance() {
		if(cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		//Connection conn = null;
		//Properties prop = new Properties();
		String username = "root";
		String password = "password";
		String url = "jdbc:postgresql://sandradb.cbgpsxwsco96.us-east-2.rds.amazonaws.com:5432/postgres";
		//Connection conn = DriverManager.getConnection(this.url,this.username, this.password);
		
		
//		try {
//			prop.load(new FileReader("database.properties"));
//			conn = DriverManager.getConnection(
//					prop.getProperty("url"), 
//					prop.getProperty("username"),
//					prop.getProperty("password")	
//				);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		return conn;
	}
}
