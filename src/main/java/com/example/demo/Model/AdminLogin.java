package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myadmin")
public class AdminLogin
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String adminName;
	private String adminPassword;
	
	
	
	public AdminLogin() {
	
	}
	public AdminLogin( String adminName, String adminPassword) {
		
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
	
	
}

