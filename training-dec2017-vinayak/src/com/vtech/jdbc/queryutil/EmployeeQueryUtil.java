package com.vtech.jdbc.queryutil;

public class EmployeeQueryUtil {
	public static String ADD_EMPLOYEE_DETAILS = "insert into m_employee_details_vinayak(emp_first_name,emp_last_name,company,emp_age,phoneno,address,zipcode,salary,isactive) values(?,?,?,?,?,?,?,?,?)";
	public static String UPDATE_EMPLOYEE_DETAILS = "update m_employee_details_vinayak set emp_first_name =?,emp_last_name =?,company =?,emp_age =?,phoneno=?,address =?,zipcode =?,salary =? where p_empid=? ";
	public static String REMOVE_EMPLOYEE_DETAILS = "update m_employee_details_vinayak set isActive = ? where p_empid =?";
	public static String GET_ALL_ACTIVATED_EMPLOYEE = "select * from m_employee_details_vinayak where isactive='Y'";
	public static String GET_EMPLOYEE_ID = "select p_empid from m_employee_details_vinayak where phoneno = ?";
	public static String COUNT_OF_EMPLOYEE = "select count(p_empid) as count from m_employee_details_vinayak where phoneno =?";
	public static String IS_EMPLOYEE_ALREADY_REMOVE = "select isactive from m_employee_details_vinayak where phoneno =?";
	public static String EMPLOYEE_PRESENT_WITH_ID = "select count(p_empid) as count from m_employee_details_vinayak where p_empid = ?";

	public static String ADD_EMPLOYEE_SKILL_DETAILS = "insert into m_employeeskills_vinayak(emp_xid,skill,exprience,isactive) values(?,?,?,?)";
	public static String UPDATE_EMPLOYEE_SKILL_DETAILS = "update m_employeeskills_vinayak set skill=?,exprience=? where emp_xid = ? and isactive!='Y'";
	public static String REMOVE_EMPLOYEE_SKILL_DETAILS = "update m_employeeskills_vinayak set isactive =? where emp_xid =? and skill =?";
	public static String REMOVE_EMPLOYEE_FROM_EMPLOYEE_SKILL = "update m_employeeskills_vinayak set isactive =? where emp_xid = ?";

	public static String GET_ALL_ACTIVATED_EMPLOYEE_SKILL = "select * from m_employeeskills_vinayak where isactive!='N'";
	public static String EMPLOYEE_PRESENT_WITH__EMPLOYEE_ID_IN_SKILL = "select count(emp_xid) as count from m_employeeskills_vinayak where emp_xid = ?";
	public static String IS_SKILL_NAME_PRESENT_WITH_EMPLOYEE_ID = "select count(skill) count from m_employeeskills_vinayak where skill=? and emp_xid=?";

	public static String IS_EMPLOYEE_ID_PRESENT_IN_EDUCATION_DETAILS = "select count(emp_xid) as count from m_employee_education_vinayak where emp_xid=? and isactive='Y'";
	public static String IS_EMPLOYEE_ID_PRESENT_WITH_EDUCATION_CLASS = "select count(emp_xid)as count from m_employee_education_vinayak where emp_xid=? and education_class=? ";
	public static String EMPLOYEE_ID_PRESENT_WITH_EDUCATION_CLASS_IS_ACTIVE = "select count(emp_xid)as count from m_employee_education_vinayak where emp_xid=? and education_class=? and isactive='Y' ";
	public static String ADD_EMPLOYEE_EDUCATION_INFORMATION = "insert into m_employee_education_vinayak (emp_xid,university,education_class,score,isactive) values (?,?,?,?,?)";
	public static String UPDATE_EMPLOYEE_EDUCATION_INFORMATION = "update m_employee_education_vinayak set university=?,education_class=?,score=? where emp_xid=? and education_class=? and isactive='Y'";
	public static String REMOVE_EMPLOYEE_EDUCATION_INFORMATION ="update m_employee_education_vinayak set isactive='N' where emp_xid=? and education_class=? and isactive='Y'";
	public static String REMOVE_EMPLOYEE_EDUCATION_INFORMATION_WITH_ID ="update m_employee_education_vinayak set isactive='N' where emp_xid=? and isactive='Y'";
	public static String GET_ALL_ACTIVATED_EMPLOYEE_EDUCATION = "select * from m_employee_education_vinayak where isactive='Y'";

}
