package com.vtech.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vtech.jdbc.helper.LoginBean;
import com.vtech.jdbc.queryutil.LoginQueryUtil;



public class LoginForDAO {
	public void addLoginCredential(LoginBean objLoginBean, int empXid) throws SQLException {
		PreparedStatement objPrepareStatement = null;
		Connection objConnection = null;
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPrepareStatement = objConnection.prepareStatement(LoginQueryUtil.ADD_LOGIN_CREDENTIAL);
			int counter = 1;
			objPrepareStatement.setInt(counter++, empXid);
			objPrepareStatement.setString(counter++, objLoginBean.getUsername());
			objPrepareStatement.setString(counter++, objLoginBean.getPassword());
			objPrepareStatement.setString(counter++, "Limited");
			int updatedRows = objPrepareStatement.executeUpdate();
		} catch (SQLException objSqlException) {
			System.out.println("Error in insert login credentil please try again");
			objConnection.rollback();
		} finally {
			objConnection.commit();
			DatabaseUtil.close(objConnection, objPrepareStatement);
		}

	}

	public void updateLoginCredential(LoginBean objLoginBean, String userName) throws SQLException {
		PreparedStatement objPrepareStatement = null;
		Connection objConnection = null;
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPrepareStatement = objConnection.prepareStatement(LoginQueryUtil.UPDATE_LOGIN_CREDENTIAL);
			int counter = 1;
			objPrepareStatement.setString(counter++, objLoginBean.getPassword());
			objPrepareStatement.setString(counter++, objLoginBean.getUsername());
			int updatedRows = objPrepareStatement.executeUpdate();
		} catch (SQLException objSqlException) {
			System.out.println("Error in update login credential please try again");
			objConnection.rollback();
		} finally {
			objConnection.commit();
			DatabaseUtil.close(objConnection, objPrepareStatement);
		}
	}

	public boolean checkLoginCredential(String userName, String password) throws SQLException {
		Connection objConnection = null;
		PreparedStatement objPrepareStatement = null;
		ResultSet objResultSet = null;
		int count=0;
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPrepareStatement = objConnection.prepareStatement(LoginQueryUtil.GET_COUNT_FOR_LOGIN_CREDENTIAL);
			int counter = 1;
			objPrepareStatement.setString(counter++, userName);
			objPrepareStatement.setString(counter++, password);
			objResultSet = objPrepareStatement.executeQuery();
			if (objResultSet.next()) {
				count= objResultSet.getInt("count");
			}
		} catch (SQLException objSqlException) {
			//System.out.println("Error in update login credential please try again");
			System.out.println(objSqlException.getMessage());
		} finally {
			DatabaseUtil.close(objConnection, objPrepareStatement);
		}
		return count>0;
	}
	
	public boolean isUsernamePresent(String userName)throws SQLException{
		Connection objConnection = null;
		PreparedStatement objPrepareStatement = null;
		ResultSet objResultSet = null;
		int count=0;
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPrepareStatement = objConnection.prepareStatement(LoginQueryUtil.GET_COUNT_FOR_USERNAME);
			int counter = 1;
			objPrepareStatement.setString(counter++, userName);
			objResultSet = objPrepareStatement.executeQuery();
			if (objResultSet.next()) {
				count= objResultSet.getInt("count");
			}
		} catch (SQLException objSqlException) {
			//System.out.println("Error in update login credential please try again");
			System.out.println(objSqlException.getMessage());
		} finally {
			DatabaseUtil.close(objConnection, objPrepareStatement,objResultSet);
		}
		return count>0;
	}
}
