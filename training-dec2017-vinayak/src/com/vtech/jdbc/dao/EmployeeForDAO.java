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
import com.vtech.jdbc.queryutil.EmployeeQueryUtil;

public class EmployeeForDAO {
	public void addEmployeeInformation(EmployeeBean objEmployee) throws SQLException {
		Connection objConnection = null;
		PreparedStatement objPreparedStatement = null;
		int empId=0;
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPreparedStatement = objConnection.prepareStatement(EmployeeQueryUtil.ADD_EMPLOYEE_DETAILS);
			int count = 1;
			objPreparedStatement.setString(count++, objEmployee.getFirstName());
			objPreparedStatement.setString(count++, objEmployee.getLastName());
			objPreparedStatement.setString(count++, objEmployee.getCompany());
			objPreparedStatement.setInt(count++, objEmployee.getAge());
			objPreparedStatement.setString(count++, objEmployee.getPhoneNo());
			objPreparedStatement.setString(count++, objEmployee.getAddress());
			objPreparedStatement.setInt(count++, objEmployee.getZipCode());
			objPreparedStatement.setDouble(count++, objEmployee.getSalary());
			objPreparedStatement.setString(count++, "Y");

			int updatedRows = objPreparedStatement.executeUpdate();
		} catch (SQLException objSQLException) {
			System.out.println("Error in employee data insertion");
			objConnection.rollback();
		} finally {
			objConnection.commit();
			DatabaseUtil.close(objConnection, objPreparedStatement);
		}
	}

	public void updateEmployeeInformation(EmployeeBean objEmployeeBean, String phoneNo) throws SQLException {
		Connection objConnection = null;
		PreparedStatement objPreparedStatement = null;
		try {
			int empid = getEmployeeID(phoneNo);

			objConnection = DatabaseUtil.getConnection(objConnection);
			objPreparedStatement = objConnection.prepareStatement(EmployeeQueryUtil.UPDATE_EMPLOYEE_DETAILS);
			int count = 1;

			objPreparedStatement.setString(count++, objEmployeeBean.getFirstName());
			objPreparedStatement.setString(count++, objEmployeeBean.getLastName());
			objPreparedStatement.setString(count++, objEmployeeBean.getCompany());
			objPreparedStatement.setInt(count++, objEmployeeBean.getAge());
			objPreparedStatement.setString(count++, objEmployeeBean.getPhoneNo());
			objPreparedStatement.setString(count++, objEmployeeBean.getAddress());
			objPreparedStatement.setInt(count++, objEmployeeBean.getZipCode());
			objPreparedStatement.setDouble(count++, objEmployeeBean.getSalary());
			objPreparedStatement.setInt(count++, empid);

			int updatedRows = objPreparedStatement.executeUpdate();
		} catch (SQLException objSQLException) {
			System.out.println(objSQLException.getMessage());
			objConnection.rollback();
		} finally {
			objConnection.commit();
			DatabaseUtil.close(objConnection, objPreparedStatement);
		}
	}

	public void RemoveEmployeeFromDatabase(int empid) throws SQLException {
		Connection objConnection = null;
		PreparedStatement objPreparedStatement = null, objPrepareStatementForEmpSkill = null;
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);
			int count = 1, updatedRows = 0;
			objPreparedStatement = objConnection.prepareStatement(EmployeeQueryUtil.REMOVE_EMPLOYEE_DETAILS);
			objPreparedStatement.setString(count++, "N");
			objPreparedStatement.setInt(count++, empid);
			updatedRows = objPreparedStatement.executeUpdate();
			removeAllEmployeeSkillInformationWithId(empid);
			removeAllEmployeeEducationInformationWithGivenId(empid);
		} catch (SQLException objSQlException) {
			System.out.println("Error in Connection");
			objConnection.rollback();
		} finally {
			objConnection.commit();
			DatabaseUtil.close(objConnection, objPreparedStatement);
		}
	}

	public void addEmployeeSkillInfomation(EmployeeSkills objEmployeeSkills) throws SQLException {
		Connection objConnection = null;
		PreparedStatement objPreparedStatement = null;
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);

			objPreparedStatement = objConnection.prepareStatement(EmployeeQueryUtil.ADD_EMPLOYEE_SKILL_DETAILS);
			int count = 1;

			objPreparedStatement.setInt(count++, objEmployeeSkills.getEmpXid());
			objPreparedStatement.setString(count++, objEmployeeSkills.getSkill());
			objPreparedStatement.setDouble(count++, objEmployeeSkills.getExperiance());
			objPreparedStatement.setString(count++, objEmployeeSkills.getIsactive());

			int updatedRows = objPreparedStatement.executeUpdate();
			System.out.println("employee skill added successfull");
		} catch (SQLException objSQLException) {
			System.out.println(objSQLException.getMessage());
			objConnection.rollback();
		} finally {
			objConnection.commit();
			DatabaseUtil.close(objConnection, objPreparedStatement);
		}
	}

	public void updateEmployeeSkillInfomation(EmployeeSkills objEmployeeSkills) throws SQLException {
		Connection objConnection = null;
		PreparedStatement objPreparedStatement = null;
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPreparedStatement = objConnection.prepareStatement(EmployeeQueryUtil.ADD_EMPLOYEE_SKILL_DETAILS);
			int count = 1;

			objPreparedStatement.setInt(count++, objEmployeeSkills.getEmpXid());
			objPreparedStatement.setString(count++, objEmployeeSkills.getSkill());
			objPreparedStatement.setDouble(count++, objEmployeeSkills.getExperiance());
			objPreparedStatement.setString(count++, objEmployeeSkills.getIsactive());
			int RowsUpdated = objPreparedStatement.executeUpdate();
			System.out.println("skill updation succesfull");
		} catch (SQLException objsqlException) {
			System.out.println(objsqlException.getMessage());
			objConnection.rollback();
		} finally {
			objConnection.commit();
			DatabaseUtil.close(objConnection, objPreparedStatement);
		}
	}

	public void RemoveEmployeeSkillInformation(String skillName, int xEmpId) throws SQLException {
		Connection objConnection = null;
		PreparedStatement objPreparedStatement = null;
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPreparedStatement = objConnection.prepareStatement(EmployeeQueryUtil.REMOVE_EMPLOYEE_SKILL_DETAILS);
			int count = 1;

			objPreparedStatement.setString(count++, "N");
			objPreparedStatement.setInt(count++, xEmpId);
			objPreparedStatement.setString(count++, skillName);

			int updatedRows = objPreparedStatement.executeUpdate();
			System.out.println("Employee with " + skillName + "successfully remove");
		} catch (SQLException objSQLException) {
			System.out.println(objSQLException.getMessage());
			objConnection.rollback();
		} finally {
			objConnection.commit();
			DatabaseUtil.close(objConnection, objPreparedStatement);
		}
	}

	public void removeAllEmployeeSkillInformationWithId(int xEmpId) throws SQLException {
		Connection objConnection = null;
		PreparedStatement objPreparedStatement = null;
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPreparedStatement = objConnection
					.prepareStatement(EmployeeQueryUtil.REMOVE_EMPLOYEE_FROM_EMPLOYEE_SKILL);
			int count = 1;

			objPreparedStatement.setString(count++, "N");
			objPreparedStatement.setInt(count++, xEmpId);

			int updatedRows = objPreparedStatement.executeUpdate();
		} catch (SQLException objSQLException) {
			System.out.println(objSQLException.getMessage());
			objConnection.rollback();
		} finally {
			objConnection.commit();
			DatabaseUtil.close(objConnection, objPreparedStatement);
		}
	}

	public int getEmployeeID(String phoneNo) throws SQLException {
		int empid = 0, count = 1;
		Connection objConnection = null;
		PreparedStatement objPreparedStatement = null;
		ResultSet objResultSet = null;
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPreparedStatement = objConnection.prepareStatement(EmployeeQueryUtil.GET_EMPLOYEE_ID);
			objPreparedStatement.setString(count++, phoneNo);
			objResultSet = objPreparedStatement.executeQuery();
			if (objResultSet.next()) {
				empid = Integer.parseInt(objResultSet.getString("p_empid"));
			}
		} catch (SQLException objSqlException) {
			System.out.println("Error In connection for retrive empid");
			objConnection.rollback();
		} finally {
			objConnection.commit();
			DatabaseUtil.close(objConnection, objPreparedStatement, objResultSet);
		}
		return empid;
	}

	public List<EmployeeBean> getListOfAllEmployeeFromDb() throws SQLException {
		Connection objConnection = null;
		ResultSet objResultSet = null;
		PreparedStatement objPrepareStatment = null;
		List<EmployeeBean> employeeList = new LinkedList<>();
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPrepareStatment = objConnection.prepareStatement(EmployeeQueryUtil.GET_ALL_ACTIVATED_EMPLOYEE);
			objResultSet = objPrepareStatment.executeQuery();
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
		} catch (SQLException objSqlException) {
			System.out.println("Error in connection");
		} finally {
			DatabaseUtil.close(objConnection, objPrepareStatment, objResultSet);
		}
		return employeeList;
	}

	public List<EmployeeSkills> getListOfAllEmployeeFromSkillDb() throws SQLException {
		Connection objConnection = null;
		PreparedStatement objPrepareStatment = null;
		ResultSet objResultSet = null;
		List<EmployeeSkills> employeeSkillList = null;
		try {
			employeeSkillList = new LinkedList<>();
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPrepareStatment = objConnection.prepareStatement(EmployeeQueryUtil.GET_ALL_ACTIVATED_EMPLOYEE_SKILL);
			objResultSet = objPrepareStatment.executeQuery();
			while (objResultSet.next()) {
				EmployeeSkills objEmployeeSkillBean = new EmployeeSkills();
				objEmployeeSkillBean.setSkillPid(objResultSet.getInt("skill_pid"));
				objEmployeeSkillBean.setEmpXid(objResultSet.getInt("emp_xid"));
				objEmployeeSkillBean.setSkill(objResultSet.getString("skill"));
				objEmployeeSkillBean.setExperiance(objResultSet.getDouble("exprience"));
				objEmployeeSkillBean.setIsactive(objResultSet.getString("isactive"));
				employeeSkillList.add(objEmployeeSkillBean);
			}
		} catch (SQLException objSqlException) {
			System.out.println(objSqlException.getMessage());
		} finally {
			DatabaseUtil.close(objConnection, objPrepareStatment, objResultSet);
		}
		return employeeSkillList;
	}

	public List<EmployeeEducationBean> getListOfAllEmployeeFromEducationDb() throws SQLException {
		Connection objConnection = null;
		PreparedStatement objPrepareStatment = null;
		ResultSet objResultSet = null;
		List<EmployeeEducationBean> employeeEducationList = null;
		try {
			employeeEducationList = new LinkedList<>();
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPrepareStatment = objConnection.prepareStatement(EmployeeQueryUtil.GET_ALL_ACTIVATED_EMPLOYEE_EDUCATION);
			objResultSet = objPrepareStatment.executeQuery();
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
		} catch (SQLException objSqlException) {
			System.out.println("Error in connection for retrive employee education details");
		} finally {
			DatabaseUtil.close(objConnection, objPrepareStatment, objResultSet);
		}
		return employeeEducationList;
	}

	public void addEmployeeEductionInformation(EmployeeEducationBean objEmployeeEducationBean) throws SQLException {
		Connection objConnection = null;
		PreparedStatement objPreparedStatement = null;
		try {
			int count = 1;
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPreparedStatement = objConnection.prepareStatement(EmployeeQueryUtil.ADD_EMPLOYEE_EDUCATION_INFORMATION);

			objPreparedStatement.setInt(count++, objEmployeeEducationBean.getEmpXid());
			objPreparedStatement.setString(count++, objEmployeeEducationBean.getUniversity());
			objPreparedStatement.setString(count++, objEmployeeEducationBean.getEducation_class());
			objPreparedStatement.setDouble(count++, objEmployeeEducationBean.getScore());
			objPreparedStatement.setString(count++, objEmployeeEducationBean.getIsactive());

			int updatedRows = objPreparedStatement.executeUpdate();
		} catch (SQLException objSqlException) {
			objConnection.rollback();
			System.out.println("Error in add employee education details please try again");
		} finally {
			objConnection.commit();
			DatabaseUtil.close(objConnection, objPreparedStatement);
		}
	}

	public void updateEmployeeEducationInformation(EmployeeEducationBean objEmployeeEducationBean,
			String educationClass) throws SQLException {
		Connection objConnection = null;
		PreparedStatement objPreparedStatement = null;
		ResultSet objResultSet = null;
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPreparedStatement = objConnection
					.prepareStatement(EmployeeQueryUtil.UPDATE_EMPLOYEE_EDUCATION_INFORMATION);
			int count = 1;
			objPreparedStatement.setString(count++, objEmployeeEducationBean.getUniversity());
			objPreparedStatement.setString(count++, objEmployeeEducationBean.getEducation_class());
			objPreparedStatement.setDouble(count++, objEmployeeEducationBean.getScore());
			objPreparedStatement.setInt(count++, objEmployeeEducationBean.getEmpXid());
			objPreparedStatement.setString(count++, educationClass);
			int updatedRows = objPreparedStatement.executeUpdate();
		} catch (SQLException objSqlException) {
			System.out.println("Error update employee education details please try again");
			objConnection.rollback();
		} finally {
			objConnection.commit();
			DatabaseUtil.close(objConnection, objPreparedStatement);
		}
	}

	public void removeEmployeeEducationInformation(EmployeeEducationBean objEmployeeEducationBean) throws SQLException {
		Connection objConnection = null;
		PreparedStatement objPrepareStatement = null;
		int removeRows = 0;
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPrepareStatement = objConnection
					.prepareStatement(EmployeeQueryUtil.REMOVE_EMPLOYEE_EDUCATION_INFORMATION);
			int count = 1;
			objPrepareStatement.setInt(count++, objEmployeeEducationBean.getEmpXid());
			objPrepareStatement.setString(count++, objEmployeeEducationBean.getEducation_class());
			removeRows = objPrepareStatement.executeUpdate();
		} catch (SQLException objSqlException) {
			System.out.println("Error in Remove employee education details please try again");
			objConnection.rollback();
		} finally {
			objConnection.commit();
			DatabaseUtil.close(objConnection, objPrepareStatement);
		}
	}
	
	public void removeAllEmployeeEducationInformationWithGivenId(int empId)throws SQLException{
		Connection objConnection = null;
		PreparedStatement objPrepareStatement = null;
		int removeRows = 0;
		try {
			objConnection = DatabaseUtil.getConnection(objConnection);
			objPrepareStatement = objConnection
					.prepareStatement(EmployeeQueryUtil.REMOVE_EMPLOYEE_EDUCATION_INFORMATION_WITH_ID);
			int count = 1;
			objPrepareStatement.setInt(count++, empId);
			removeRows = objPrepareStatement.executeUpdate();
		} catch (SQLException objSqlException) {
			System.out.println("Error in Remove employee education details please try again");
			objConnection.rollback();
		} finally {
			objConnection.commit();
			DatabaseUtil.close(objConnection, objPrepareStatement);
		}
	}
}
