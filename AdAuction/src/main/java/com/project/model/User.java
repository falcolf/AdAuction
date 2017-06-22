package com.project.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AUCTION_USERS")
public class User {
	
	@Column(name="NAME",nullable=false)
	private String name;
	
	@Id @Column(name="EMAIL" , unique=true , nullable=false)
	private String email;
	
	@Column(name="PASSWORD",nullable=false)
	private String password;
	
	@Column(name="ADHAAR_NUMBER",unique=true,nullable=false)
	private String adhaarno;
	
	@Column(name="STATE",nullable=false)
	private String state=State.INACTIVE.getState();
	
	@Column(name="ACC_TYPE",nullable=false)
	private String type=UserProfileType.USER.getUserProfileType();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdhaarno() {
		return adhaarno;
	}

	public void setAdhaarno(String adhaarno) {
		this.adhaarno = adhaarno;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
