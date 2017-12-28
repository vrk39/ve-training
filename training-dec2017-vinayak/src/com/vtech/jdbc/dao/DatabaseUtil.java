package com.vtech.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtil {
	
	public static Connection getConnection(Connection objForConnection) {
		if (null == objForConnection) {
			try {
				Class.forName("org.postgresql.Driver");
				objForConnection = DriverManager.getConnection("jdbc:postgresql://192.168.0.93:5432/training_2014",
						"trainingteam", "verc_trainingteam");
				objForConnection.setAutoCommit(false);
				return objForConnection;
			} catch (ClassNotFoundException objClassNotFound) {
				System.out.println(objClassNotFound.getMessage());
			} catch (SQLException objSqlException) {
				System.out.println("sql exception occured");
			}
		}
		return objForConnection;
	}
	
	public static void close(Connection objConncection)throws SQLException{
		objConncection.close();
	}
	
	public static void close(PreparedStatement objPrepareStatement)throws SQLException{
		objPrepareStatement.close();
	}
	
	public static void close(Connection objConnection , PreparedStatement objPrepareStatement)throws SQLException{
		objConnection.close();
		objPrepareStatement.close();
	}
	
	public static void close(Connection objConnection, PreparedStatement objPrepareStatement , ResultSet objResultTest){
		try{
			objConnection.close();
			objPrepareStatement.close();
			objResultTest.close();
		}catch(SQLException objSqlException){
			System.out.println("Error In object closing");
		}
		
	}
}
