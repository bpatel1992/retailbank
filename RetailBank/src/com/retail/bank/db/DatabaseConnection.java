package com.retail.bank.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static final String DRIVER_NAME= "com.mysql.jdbc.Driver";
	public static final String URL= "jdbc:mysql://localhost:3306/retailbank";
	public static final String USER_NAME= "root";
	public static final String PASSWORD= "root";
	public static Connection getConnection() throws ClassNotFoundException {
		Connection con =  null;
		try{  
			Class.forName(DRIVER_NAME);  
			con=DriverManager.getConnection(  
			URL,USER_NAME,PASSWORD);  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
