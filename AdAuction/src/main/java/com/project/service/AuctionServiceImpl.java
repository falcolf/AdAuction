package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.AuctionDao;
import com.project.dao.AuctionDaoImpl;
import com.project.model.Auction;
@Service("auctionService")
@Transactional
public class AuctionServiceImpl implements AuctionService{

	@Autowired
	private AuctionDaoImpl dao;
	
	@Override
	public void scheduleAuction(Auction data) {
		dao.scheduleAuction(data);
		
	}

	@Override
	public void deleteData(int id) {
		Auction data=dao.getByKey(id);
		dao.delete(data);
		
	}

	@Override
	public Auction getDetails(int id) {
		
		return dao.getByKey(id);
	}

	@Override
	public void updateBid(Auction data) {
		dao.updateBid(data);
		
	}
	public List<Auction> getAllAuc(){
		return dao.getAllAuctions();
	}

	@Override
	public void refreshList() {
		dao.refreshList();
		
	}

}
