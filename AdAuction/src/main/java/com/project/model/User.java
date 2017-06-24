package com.project.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AUCTION_USERS")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="NAME",nullable=false)
	private String name;
	
	@Column(name="EMAIL" , unique=true , nullable=false)
	private String email;
	
	@Column(name="PASSWORD",nullable=false)
	private String password;
	
	@Column(name="ADHAAR_NUMBER",unique=true,nullable=false)
	private String adhaarno;
	
	@Column(name="STATE",nullable=false)
	private String state;
	/*
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="AUCTION_USER_USER_PROFILE",
	joinColumns={@JoinColumn(name="USER_PROFILE_ID")},
	inverseJoinColumns={@JoinColumn(name="USER_ID")})
	private Set<UserProfile> upros=new HashSet<UserProfile>();
	*/
	@Column(name="TYPE_ID",nullable=false)
	private int typeid;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*public Set<UserProfile> getUpros() {
		return upros;
	}

	public void setUpros(Set<UserProfile> upros) {
		this.upros = upros;
	}
	*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password
				+ ", Name=" + name +  ", Adhaar Number=" + adhaarno + ", state=" + state + ", userProfiles=" + typeid +"]";
	}
	


}
