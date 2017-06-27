package com.project.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.model.Auction;

import sendmail.ProduceMail;


@Repository("auctionDao")
public class AuctionDaoImpl extends AbstractDao<Integer,Auction> implements AuctionDao {

	final String url="192.168.1.6:8089/AdAuction/user/paymets";
	@Override
	public void scheduleAuction(Auction data) {
		getSession().save(data);
		
	}

	@Override
	public void endAuction(Auction data) {
		getSession().delete(data);
		String desc=data.getName()+"( "+data.getUrl()+" )"+" With Ad Type : "+data.getType()+" ";
		ProduceMail pm=new ProduceMail();
		pm.congratsMail(data.getHighbidder(), data.getHighbidder(), url, desc, Double.toString(data.getCurrbid()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Auction> getAllAuctions() {
		List<Auction> list=new ArrayList<Auction>();
		this.refreshList();
		list=getSession().createCriteria(Auction.class).list();
		return list;
	}

	@Override
	public void updateBid(Auction data) {
		getSession().update(data);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void refreshList() {
		List<Auction> list=new ArrayList<Auction>();
		list=getSession().createCriteria(Auction.class).list();
		Iterator<Auction> it=list.iterator();
		while(it.hasNext()){
			Auction a=(Auction) it.next();
			Calendar c=Calendar.getInstance();
			Date d=c.getTime();
			if(!d.before(a.getEndtime())){
				this.endAuction(a);
			}
		}
		
	}
	
	
	

}
