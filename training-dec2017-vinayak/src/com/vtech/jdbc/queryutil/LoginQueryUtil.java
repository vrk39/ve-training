package com.vtech.jdbc.queryutil;

public class LoginQueryUtil {
	public static String ADD_LOGIN_CREDENTIAL = "insert into m_employee_login_details_vinayak(emp_xid,username,login_password,permission) values(?,?,?,?)";
	public static String UPDATE_LOGIN_CREDENTIAL ="update m_employee_login_details_vinayak set login_password =? where username=?";
	public static String GET_COUNT_FOR_LOGIN_CREDENTIAL ="select count(login_pid) as count from m_employee_login_details_vinayak where username=? and login_password=?";
	public static String GET_COUNT_FOR_USERNAME ="select count(username)as count from m_employee_login_details_vinayak where username =?";
	public static String GET_EMPID_FOR_USERNAME="select emp_xid from m_employee_login_details_vinayak where username = ?";
}
