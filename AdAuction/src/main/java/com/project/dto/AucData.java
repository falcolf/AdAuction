package com.project.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;

public class AucData {
	
	@NotNull
	private String name;
	
	@NotNull
	private String url;
	
	@NotNull
	private String type;
	
	@NotNull
	private String currbid;
	
	@NotNull 
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	private String starttime;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	private String endtime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCurrbid() {
		return currbid;
	}
	public void setCurrbid(String currbid) {
		this.currbid = currbid;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	
}
