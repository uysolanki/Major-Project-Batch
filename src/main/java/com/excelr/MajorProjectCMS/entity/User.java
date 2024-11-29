package com.excelr.MajorProjectCMS.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	private String username;
	private String password;
	
	private LocalDate accountExpiryDate;
	   private int accountLockedStatus;
	   private LocalDate credentialtExpiryDate;
	   private int accountEnabledStatus;
	
	public User() {}
	public User(Long userid, String username, String password) {
		this.userid = userid;
		this.username = username;
		this.password = password;
	}
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	   @JoinTable(
	           name = "users_roles",
	           joinColumns = @JoinColumn(name = "user_id"),
	           inverseJoinColumns = @JoinColumn(name = "role_id")
	           )
	private List<Role> roles;

	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public LocalDate getAccountExpiryDate() {
		return accountExpiryDate;
	}
	public void setAccountExpiryDate(LocalDate accountExpiryDate) {
		this.accountExpiryDate = accountExpiryDate;
	}
	public int getAccountLockedStatus() {
		return accountLockedStatus;
	}
	public void setAccountLockedStatus(int accountLockedStatus) {
		this.accountLockedStatus = accountLockedStatus;
	}
	public LocalDate getCredentialtExpiryDate() {
		return credentialtExpiryDate;
	}
	public void setCredentialtExpiryDate(LocalDate credentialtExpiryDate) {
		this.credentialtExpiryDate = credentialtExpiryDate;
	}
	public int getAccountEnabledStatus() {
		return accountEnabledStatus;
	}
	public void setAccountEnabledStatus(int accountEnabledStatus) {
		this.accountEnabledStatus = accountEnabledStatus;
	}
	
	
}
