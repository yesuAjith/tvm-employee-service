package com.tvmemployee.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class TvmEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer employeeid;
	private String employeefirstname;
	private String employeelastname;
	private String employeeemail;
	private Long employeesalary;
	private String employeephone;

	@OneToMany(targetEntity = EmployeeEducation.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeid")
	private List<EmployeeEducation> employeeEducation;

	@OneToMany(targetEntity = EmployeeAddress.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeid")
	private List<EmployeeAddress> employeeAddress;
	
	@OneToMany(targetEntity = EmployeeAssets.class, cascade = CascadeType.ALL)
	@JoinColumn(name="emp_id")
	private List<EmployeeAssets>employeeasset;

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeefirstname() {
		return employeefirstname;
	}

	public void setEmployeefirstname(String employeefirstname) {
		this.employeefirstname = employeefirstname;
	}

	public String getEmployeelastname() {
		return employeelastname;
	}

	public void setEmployeelastname(String employeelastname) {
		this.employeelastname = employeelastname;
	}

	public String getEmployeeemail() {
		return employeeemail;
	}

	public void setEmployeeemail(String employeeemail) {
		this.employeeemail = employeeemail;
	}

	public Long getEmployeesalary() {
		return employeesalary;
	}

	public void setEmployeesalary(Long employeesalary) {
		this.employeesalary = employeesalary;
	}

	public String getEmployeephone() {
		return employeephone;
	}

	public void setEmployeephone(String employeephone) {
		this.employeephone = employeephone;
	}

	public List<EmployeeEducation> getEmployeeEducation() {
		return employeeEducation;
	}

	public void setEmployeeEducation(List<EmployeeEducation> employeeEducation) {
		this.employeeEducation = employeeEducation;
	}

	public List<EmployeeAddress> getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(List<EmployeeAddress> employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public List<EmployeeAssets> getEmployeeasset() {
		return employeeasset;
	}

	public void setEmployeeasset(List<EmployeeAssets> employeeasset) {
		this.employeeasset = employeeasset;
	}
	
	

	}