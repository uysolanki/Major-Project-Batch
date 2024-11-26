package com.excelr.MajorProjectCMS.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cno;
	private String firstname;
	private String lastname;
	private String email;
	private String mobileno;
	private String gender;
	
	//NoArgsConstructor
	public Customer() {} 
	
	//AllArgsConstructor
	public Customer(int cno, String firstname, String lastname, String email, String mobileno, String gender) {
		this.cno = cno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobileno = mobileno;
		this.gender = gender;
	}

	//Gettet
	public int getCno() {
		return cno;
	}

	//Setter
	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	//ToString
	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", mobileno=" + mobileno + ", gender=" + gender + "]";
	}
	
	
	
}
