package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="AUCTION_OTP")
public class Otp {
	@Id
	private int id;
	@Column(name="EMAIL",nullable=false,unique=true)
	private String email;
	@Column(name="OTP",nullable=false,length=4)
	private String otp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	
}
