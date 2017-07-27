package com.project.service;

import java.util.List;

import com.project.model.Auction;

public interface AuctionService {
	public void scheduleAuction(Auction data);
	public void deleteData(int id);
	public Auction getDetails(int id);
	public void updateBid(Auction data);
	public List<Auction> getAllAuc();
	public void refreshList();
	public List<Auction> getAucByEmail(String email);
	
}
