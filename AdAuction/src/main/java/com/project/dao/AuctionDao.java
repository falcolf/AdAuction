package com.project.dao;

import java.util.List;

import com.project.model.Auction;

public interface AuctionDao {
	public void scheduleAuction(Auction data);
	public void endAuction(Auction data);
	public void updateBid(Auction data);
	public List<Auction> getAllAuctions();
	public List<Auction> getAucbyEmail(String email);
	public void refreshList();
}
