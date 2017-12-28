package com.vtech.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.vtech.jdbc.helper.EmployeeBean;
import com.vtech.jdbc.helper.EmployeeEducationBean;
import com.vtech.jdbc.helper.EmployeeSkills;
import com.vtech.jdbc.queryutil.EmployeeDetailsSearchQueryUtil;

public class SearchEmployeeDetailsDAO {
	public List<EmployeeBean> getEmployeeDetailsListByAgeLessThanOrEqualToGivenAge(int emp_age)throws SQLException{
		Connection objConnection = null;
		PreparedStatement objPrepareStatement = null;
		ResultSet objResultSet = null;
		List<EmployeeBean> employeeList = new LinkedList<>();
		try{
			objConnection = DatabaseUtil.getConnection(objConnection);
			int count=1;
			objPrepareStatement = objConnection.prepareStatement(EmployeeDetailsSearchQueryUtil.GET_EMPLOYEE_DETAILS_FOR_AGE_LESS_THAN_OR_EQUAL_TO_GIVEN_AGE);
			objPrepareStatement.setInt(count++, emp_age);
			objResultSet = objPrepareStatement.executeQuery();
			while (objResultSet.next()) {
				EmployeeBean objEmployeeBean = new EmployeeBean();
				objEmployeeBean.setEmp_id(objResultSet.getInt("p_empid"));
				objEmployeeBean.setFirstName(objResultSet.getString("emp_first_Name"));
				objEmployeeBean.setLastName(objResultSet.getString("emp_last_Name"));
				objEmployeeBean.setCompany(objResultSet.getString("company"));
				objEmployeeBean.setAge(objResultSet.getInt("emp_age"));
				objEmployeeBean.setPhoneNo(objResultSet.getString("phoneno"));
				objEmployeeBean.setAddress(objResultSet.getString("address"));
				objEmployeeBean.setZipCode(objResultSet.getInt("zipcode"));
				objEmployeeBean.setSalary(objResultSet.getFloat("salary"));
				objEmployeeBean.setIsActive(objResultSet.getString("isactive"));
				employeeList.add(objEmployeeBean);
			}
		}catch(SQLException objSqlException){
			System.out.println("Error in fetch employee details for given age");
		}finally {
			DatabaseUtil.close(objConnection, objPrepareStatement, objResultSet);
		}
		return employeeList;
	}
	
	public List<EmployeeBean> getEmployeeDetailsListByAgeGreaterThanGivenAge(int emp_age)throws SQLException{
		Connection objConnection = null;
		PreparedStatement objPrepareStatement = null;
		ResultSet objResultSet = null;
		List<EmployeeBean> employeeList = new LinkedList<>();
		try{
			objConnection = DatabaseUtil.getConnection(objConnection);
			int count=1;
			objPrepareStatement = objConnection.prepareStatement(EmployeeDetailsSearchQueryUtil.GET_EMPLOYEE_DETAILS_FOR_AGE_GREATER_THAN_GIVEN_AGE);
			objPrepareStatement.setInt(count++, emp_age);
			objResultSet = objPrepareStatement.executeQuery();
			while (objResultSet.next()) {
				EmployeeBean objEmployeeBean = new EmployeeBean();
				objEmployeeBean.setEmp_id(objResultSet.getInt("p_empid"));
				objEmployeeBean.setFirstName(objResultSet.getString("emp_first_Name"));
				objEmployeeBean.setLastName(objResultSet.getString("emp_last_Name"));
				objEmployeeBean.setCompany(objResultSet.getString("company"));
				objEmployeeBean.setAge(objResultSet.getInt("emp_age"));
				objEmployeeBean.setPhoneNo(objResultSet.getString("phoneno"));
				objEmployeeBean.setAddress(objResultSet.getString("address"));
				objEmployeeBean.setZipCode(objResultSet.getInt("zipcode"));
				objEmployeeBean.setSalary(objResultSet.getFloat("salary"));
				objEmployeeBean.setIsActive(objResultSet.getString("isactive"));
				employeeList.add(objEmployeeBean);
			}
		}catch(SQLException objSqlException){
			System.out.println("Error in fetch employee details for given age");
		}finally {
			DatabaseUtil.close(objConnection, objPrepareStatement, objResultSet);
		}
		return employeeList;
	}
	
	public List<EmployeeBean> getEmployeeDetailsListByFirstName(String firstName)throws SQLException{
		Connection objConnection = null;
		PreparedStatement objPrepareStatement = null;
		ResultSet objResultSet = null;
		List<EmployeeBean> employeeList = new LinkedList<>();
		try{
			objConnection = DatabaseUtil.getConnection(objConnection);
			int count=1;
			objPrepareStatement = objConnection.prepareStatement(EmployeeDetailsSearchQueryUtil.GET_EMPLOYEE_DETAILS_MATCHES_WITH_FIRST_NAME);
			objPrepareStatement.setString(count++, firstName);
			objResultSet = objPrepareStatement.executeQuery();
			while (objResultSet.next()) {
				EmployeeBean objEmployeeBean = new EmployeeBean();
				objEmployeeBean.setEmp_id(objResultSet.getInt("p_empid"));
				objEmployeeBean.setFirstName(objResultSet.getString("emp_first_Name"));
				objEmployeeBean.setLastName(objResultSet.getString("emp_last_Name"));
				objEmployeeBean.setCompany(objResultSet.getString("company"));
				objEmployeeBean.setAge(objResultSet.getInt("emp_age"));
				objEmployeeBean.setPhoneNo(objResultSet.getString("phoneno"));
				objEmployeeBean.setAddress(objResultSet.getString("address"));
				objEmployeeBean.setZipCode(objResultSet.getInt("zipcode"));
				objEmployeeBean.setSalary(objResultSet.getFloat("salary"));
				objEmployeeBean.setIsActive(objResultSet.getString("isactive"));
				employeeList.add(objEmployeeBean);
			}
		}catch(SQLException objSqlException){
			System.out.println(objSqlException.getMessage());
			//System.out.println("Error in fetch employee details for given name");
		}finally {
			DatabaseUtil.close(objConnection, objPrepareStatement, objResultSet);
		}
		return employeeList;
	}

	public List<EmployeeBean> getEmployeeDetailsListForSalary(double salary)throws SQLException{
		Connection objConnection = null;
		PreparedStatement objPrepareStatement = null;
		ResultSet objResultSet = null;
		List<EmployeeBean> employeeList = new LinkedList<>();
		try{
			objConnection = DatabaseUtil.getConnection(objConnection);
			int count=1;
			objPrepareStatement = objConnection.prepareStatement(EmployeeDetailsSearchQueryUtil.GET_EMPLOYEE_DETAILS_FOR_SALARY);
			objPrepareStatement.setDouble(count++, salary);
			objResultSet = objPrepareStatement.executeQuery();
			while (objResultSet.next()) {
				EmployeeBean objEmployeeBean = new EmployeeBean();
				objEmployeeBean.setEmp_id(objResultSet.getInt("p_empid"));
				objEmployeeBean.setFirstName(objResultSet.getString("emp_first_Name"));
				objEmployeeBean.setLastName(objResultSet.getString("emp_last_Name"));
				objEmployeeBean.setCompany(objResultSet.getString("company"));
				objEmployeeBean.setAge(objResultSet.getInt("emp_age"));
				objEmployeeBean.setPhoneNo(objResultSet.getString("phoneno"));
				objEmployeeBean.setAddress(objResultSet.getString("address"));
				objEmployeeBean.setZipCode(objResultSet.getInt("zipcode"));
				objEmployeeBean.setSalary(objResultSet.getFloat("salary"));
				objEmployeeBean.setIsActive(objResultSet.getString("isactive"));
				employeeList.add(objEmployeeBean);
			}
		}catch(SQLException objSqlException){
			System.out.println("Error in fetch employee details for given salary");
		}finally {
			DatabaseUtil.close(objConnection, objPrepareStatement, objResultSet);
		}
		return employeeList;
	}
	
	public List<EmployeeSkills> getEmployeeDetailsListForSkill(String skill)throws SQLException{
		Connection objConnection = null;
		PreparedStatement objPrepareStatement = null;
		ResultSet objResultSet = null;
		List<EmployeeSkills> employeeSkillList = new LinkedList<>();
		try{
			objConnection = DatabaseUtil.getConnection(objConnection);
			int count=1;
			objPrepareStatement = objConnection.prepareStatement(EmployeeDetailsSearchQueryUtil.GET_EMPLOYEE_DETAILS_FOR_SKILL);
			objPrepareStatement.setString(count++, skill);
			objResultSet = objPrepareStatement.executeQuery();
			while (objResultSet.next()) {
				EmployeeSkills objEmployeeSkillBean = new EmployeeSkills();
				objEmployeeSkillBean.setSkillPid(objResultSet.getInt("skill_pid"));
				objEmployeeSkillBean.setEmpXid(objResultSet.getInt("emp_xid"));
				objEmployeeSkillBean.setSkill(objResultSet.getString("skill"));
				objEmployeeSkillBean.setExperiance(objResultSet.getDouble("exprience"));
				objEmployeeSkillBean.setIsactive(objResultSet.getString("isactive"));
				employeeSkillList.add(objEmployeeSkillBean);
			}
		}catch(SQLException objSqlException){
			System.out.println("Error in fetch employee details for given salary");
		}finally {
			DatabaseUtil.close(objConnection, objPrepareStatement, objResultSet);
		}
		return employeeSkillList;
	}
	
	public List<EmployeeSkills> getEmployeeDetailsListForExprience(double exprience)throws SQLException{
		Connection objConnection = null;
		PreparedStatement objPrepareStatement = null;
		ResultSet objResultSet = null;
		List<EmployeeSkills> employeeSkillList = new LinkedList<>();
		try{
			objConnection = DatabaseUtil.getConnection(objConnection);
			int count=1;
			objPrepareStatement = objConnection.prepareStatement(EmployeeDetailsSearchQueryUtil.GET_EMPLOYEE_DETAILS_FOR_EXPERIENCE);
			objPrepareStatement.setDouble(count++, exprience);
			objResultSet = objPrepareStatement.executeQuery();
			while (objResultSet.next()) {
				EmployeeSkills objEmployeeSkillBean = new EmployeeSkills();
				objEmployeeSkillBean.setSkillPid(objResultSet.getInt("skill_pid"));
				objEmployeeSkillBean.setEmpXid(objResultSet.getInt("emp_xid"));
				objEmployeeSkillBean.setSkill(objResultSet.getString("skill"));
				objEmployeeSkillBean.setExperiance(objResultSet.getDouble("exprience"));
				objEmployeeSkillBean.setIsactive(objResultSet.getString("isactive"));
				employeeSkillList.add(objEmployeeSkillBean);
			}
		}catch(SQLException objSqlException){
			System.out.println("Error in fetch employee details for given salary");
		}finally {
			DatabaseUtil.close(objConnection, objPrepareStatement, objResultSet);
		}
		return employeeSkillList;
	}
	
	public List<EmployeeEducationBean> getEmployeeDetailsListForScore(double score)throws SQLException{
		Connection objConnection = null;
		PreparedStatement objPrepareStatement = null;
		ResultSet objResultSet = null;
		List<EmployeeEducationBean> employeeEducationList = new LinkedList<>();
		try{
			objConnection = DatabaseUtil.getConnection(objConnection);
			int count=1;
			objPrepareStatement = objConnection.prepareStatement(EmployeeDetailsSearchQueryUtil.GET_EMPLOYEE_DETAILS_FOR_EDUCATION_SCORE);
			objPrepareStatement.setDouble(count++,score);
			objResultSet = objPrepareStatement.executeQuery();
			while (objResultSet.next()) {
				EmployeeEducationBean objEmployeeSkillBean = new EmployeeEducationBean();
				objEmployeeSkillBean.setDetailPid(objResultSet.getInt("detail_pid"));
				objEmployeeSkillBean.setEmpXid(objResultSet.getInt("emp_xid"));
				objEmployeeSkillBean.setUniversity(objResultSet.getString("university"));
				objEmployeeSkillBean.setEducation_class(objResultSet.getString("education_class"));
				objEmployeeSkillBean.setScore(objResultSet.getDouble("Score"));
				objEmployeeSkillBean.setIsactive(objResultSet.getString("isactive"));
				employeeEducationList.add(objEmployeeSkillBean);
			}
		}catch(SQLException objSqlException){
			System.out.println("Error in fetch employee details for given salary");
		}finally {
			DatabaseUtil.close(objConnection, objPrepareStatement, objResultSet);
		}
		return employeeEducationList;
	}
}
