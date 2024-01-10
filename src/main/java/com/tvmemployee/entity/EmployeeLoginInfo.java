package com.tvmemployee.entity;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table
public class EmployeeLoginInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loginid;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date date;
	
	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private LocalTime time;
	
	@PrePersist
	private void onCreate() {
		date= new Date();
		time= LocalTime.now();
	}
	
	@ManyToOne(targetEntity = TvmEmployee.class)
	@JoinColumn(name="emp_id",referencedColumnName = "employeeid")
	private TvmEmployee tvm;
	public TvmEmployee getTvm() {
		return tvm;
	}
	public void setTvm(TvmEmployee tvm) {
		this.tvm = tvm;
	}
	
	public Integer getLoginid() {
		return loginid;
	}
	public void setLoginid(Integer loginid) {
		this.loginid = loginid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
	
}
