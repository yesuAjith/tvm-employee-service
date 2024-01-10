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
public class EmployeeLogofInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer logoutid;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date logoutdate;
	
	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private LocalTime logouttime;
	
	@PrePersist
	private void Oncreate() {
		logoutdate= new Date();
		logouttime= LocalTime.now();
	}
	
	@ManyToOne(targetEntity = TvmEmployee.class)
	@JoinColumn(name="employee_id",referencedColumnName = "employeeid")
	private TvmEmployee tvm;

	

	public Integer getLogoutid() {
		return logoutid;
	}

	public void setLogoutid(Integer logoutid) {
		this.logoutid = logoutid;
	}
	

	public Date getLogoutdate() {
		return logoutdate;
	}

	public void setLogoutdate(Date logoutdate) {
		this.logoutdate = logoutdate;
	}

	public LocalTime getLogouttime() {
		return logouttime;
	}

	public void setLogouttime(LocalTime logouttime) {
		this.logouttime = logouttime;
	}

	public TvmEmployee getTvm() {
		return tvm;
	}

	public void setTvm(TvmEmployee tvm) {
		this.tvm = tvm;
	}

	
	
}
