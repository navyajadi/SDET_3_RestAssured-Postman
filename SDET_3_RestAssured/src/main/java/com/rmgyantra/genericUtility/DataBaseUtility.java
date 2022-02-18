package com.rmgyantra.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	public Connection con =null;
	public ResultSet result;
	
	
	/**
	 * This method is used to connect to data base
	 * @throws SQLException
	 */
	public void connectToDataBase() {
		
		try {
			Driver dref=new Driver();
			DriverManager.registerDriver(dref);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root","root");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to close connection
	 * @throws SQLException 
	 */
		
	public void closeConnection() throws Throwable {
		
		con.close();
	}
		
	public  ResultSet executeQuery(String Query) throws SQLException {
		
		  ResultSet result = con.createStatement().executeQuery(Query);
		 
		 return result;
	}
	

}

