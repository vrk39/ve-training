package com.vtech.jdbc.helper;

public class EmployeeSkills {
	private int skillPid;
	private int empXid;
	private String skill;
	private double exprience;
	private String isactive;

	@Override
	public String toString() {
		return " " + skillPid + "| " + empXid + "| " + skill + "| " + exprience
				+ "| " + isactive + " ";
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public int getSkillPid() {
		return skillPid;
	}

	public void setSkillPid(int skillPid) {
		this.skillPid = skillPid;
	}

	public int getEmpXid() {
		return empXid;
	}

	public void setEmpXid(int empXid) {
		this.empXid = empXid;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public double getExperiance() {
		return exprience;
	}

	public void setExperiance(double experiance) {
		this.exprience =experiance;
	}

}
