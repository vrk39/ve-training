package com.vtech.jdbc.helper;

public class EmployeeBean {
	private int empid;
	private String firstName;
	private String lastName;
	private String company;
	private int age;
	private String phoneNo;
	private String address;
	private int zipCode;
	private double salary;
	private String isActive;


	public String getIsActive() {
		return isActive;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public int getEmp_id() {
		return empid;
	}

	public void setEmp_id(int empid) {
		this.empid = empid;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public EmployeeBean() {
		super();
	}

	@Override
	public String toString() {
		return "|" + empid + " | " + firstName + " | " + lastName + " | " + company + " | " + age + " | " + phoneNo
				+ " | " + address + " | " + zipCode + " | " + salary + " | " + isActive + " | ";
	}

}
