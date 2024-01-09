package com.tvmemployee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class EmployeeAssets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer assetid;
	private String laptop;
	private String headphone;
	private String keyboard;
	private String mouse;
	public Integer getAssetid() {
		return assetid;
	}
	public void setAssetid(Integer assetid) {
		this.assetid = assetid;
	}
	public String getLaptop() {
		return laptop;
	}
	public void setLaptop(String laptop) {
		this.laptop = laptop;
	}
	public String getHeadphone() {
		return headphone;
	}
	public void setHeadphone(String headphone) {
		this.headphone = headphone;
	}
	public String getKeyboard() {
		return keyboard;
	}
	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}
	public String getMouse() {
		return mouse;
	}
	public void setMouse(String mouse) {
		this.mouse = mouse;
	}
	
	
}
