package com.tvmemployee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class EmployeeEducation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qualificationid;
	private String employeequalification;
	private String yearofpassout;
	private String percentage;
	private String university;
	public Integer getQualificationid() {
		return qualificationid;
	}
	public void setQualificationid(Integer qualificationid) {
		this.qualificationid = qualificationid;
	}
	public String getEmployeequalification() {
		return employeequalification;
	}
	public void setEmployeequalification(String employeequalification) {
		this.employeequalification = employeequalification;
	}
	public String getYearofpassout() {
		return yearofpassout;
	}
	public void setYearofpassout(String yearofpassout) {
		this.yearofpassout = yearofpassout;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	

	
}
