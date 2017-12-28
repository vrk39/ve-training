package com.vtech.jdbc.helper;

public class EmployeeEducationBean {
	private int detailPid;
	private int empXid;
	private String university;
	private String educationclass;
	private double score;
	private String isactive;

	public int getDetailPid() {
		return detailPid;
	}

	public void setDetailPid(int detailPid) {
		this.detailPid = detailPid;
	}

	public int getEmpXid() {
		return empXid;
	}

	public void setEmpXid(int empXid) {
		this.empXid = empXid;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getEducation_class() {
		return educationclass;
	}

	public void setEducation_class(String education_class) {
		this.educationclass = education_class;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	@Override
	public String toString() {
		return " " + detailPid + ", " + empXid + ", " + university
				+ ", " + educationclass + ", " + score + ", " + isactive + " ";
	}

}
