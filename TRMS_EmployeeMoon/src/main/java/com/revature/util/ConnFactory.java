package com.revature.util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	
private static ConnFactory cf;

	static {
	try {
	Class.forName("org.postgresql.Driver");
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	
}
	
	private ConnFactory() {
		super();
	}
	
	//public static synchronized "getter" method
	public static synchronized ConnFactory getInstance() {
		if(cf==null) {
			cf= new ConnFactory();
		}
		return cf;
	}
	
	//methods that do stuff
	public Connection getConnection() {
		Connection conn= null;
		Properties prop = new Properties();
		
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			prop.load(loader.getResourceAsStream("database.properties"));
			conn=DriverManager.getConnection(
			prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
}
