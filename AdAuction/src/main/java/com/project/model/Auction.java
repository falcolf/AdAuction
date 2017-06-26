package com.project.model;


import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;


@Entity
@Table(name="AUCTION_DATA")
public class Auction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AUC_ID")
	private int id;
	
	@Column(name="WEB_NAME",nullable=false)
	private String name;
	
	@Column(name="WEB_URL",nullable=false)
	private String url;
	
	@Column(name="AD_TYPE",nullable=false)
	private String type;
	
	@Column(name="CURRENT_BID",nullable=false)
	private double currbid;
	
	@Column(name="HIGHEST_BIDDER",nullable=false) 
	private String highbidder;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_TIME")
	private Date starttime;

	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_TIME")
	private Date endtime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public double getCurrbid() {
		return currbid;
	}

	public void setCurrbid(double currbid) {
		this.currbid = currbid;
	}

	public String getHighbidder() {
		return highbidder;
	}

	public void setHighbidder(String highbidder) {
		this.highbidder = highbidder;
	}

	
	

	

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	@Override
	public String toString() {
		return "AdData=[name="+this.getName()+" url="+this.getUrl()+" type:"+this.getType()+" Currbid:"+this.getCurrbid()+" highbidder="+this.getHighbidder()+" startTime:"+this.getStarttime()+" endtime:"+this.getEndtime()+"]";
	}

	
}
