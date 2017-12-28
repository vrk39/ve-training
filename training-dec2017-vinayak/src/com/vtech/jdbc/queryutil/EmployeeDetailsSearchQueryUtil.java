package com.vtech.jdbc.queryutil;

public class EmployeeDetailsSearchQueryUtil {
	public static String GET_EMPLOYEE_DETAILS_FOR_AGE_LESS_THAN_OR_EQUAL_TO_GIVEN_AGE = "select * from m_employee_details_vinayak where emp_age<=? and isactive='Y'";
	public static String GET_EMPLOYEE_DETAILS_FOR_AGE_GREATER_THAN_GIVEN_AGE = "select * from m_employee_details_vinayak where emp_age > ? and isactive='Y'";

	public static String GET_EMPLOYEE_DETAILS_MATCHES_WITH_FIRST_NAME = "select * from m_employee_details_vinayak where emp_first_name like ? and isactive='Y'";
	public static String GET_EMPLOYEE_DETAILS_FOR_SALARY = "select * from m_employee_details_vinayak where salary<=? and isactive='Y'";

	public static String GET_EMPLOYEE_DETAILS_FOR_SKILL = "select * from m_employeeskills_vinayak where skill=? and isactive='Y'";
	public static String GET_EMPLOYEE_DETAILS_FOR_EXPERIENCE = "select * from m_employeeskills_vinayak where exprience <=? and isactive='Y'";

	public static String GET_EMPLOYEE_DETAILS_FOR_EDUCATION_SCORE = "select * from m_employee_education_vinayak where score<=? and isactive='Y'";
}
