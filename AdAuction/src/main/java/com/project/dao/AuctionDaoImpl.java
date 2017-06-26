package com.project.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.model.Auction;


@Repository("auctionDao")
public class AuctionDaoImpl extends AbstractDao<Integer,Auction> implements AuctionDao {

	@Override
	public void scheduleAuction(Auction data) {
		getSession().save(data);
		
	}

	@Override
	public void endAuction(Auction data) {
		getSession().delete(data);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Auction> getAllAuctions() {
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
		
		list=getSession().createCriteria(Auction.class).list();
		return list;
	}

	@Override
	public void updateBid(Auction data) {
		getSession().update(data);
		
	}

}
