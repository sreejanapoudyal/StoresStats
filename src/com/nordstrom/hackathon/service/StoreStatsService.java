package com.nordstrom.hackathon.service;

import com.nordstrom.hackathon.Exception.CustomException;
import com.nordstrom.hackathon.dao.StoreStatsDao;
import com.nordstrom.hackathon.domain.ItemsCount;
import com.nordstrom.hackathon.domain.Store;

public class StoreStatsService {
	
	StoreStatsDao dao = new StoreStatsDao();

	public Store getStoreDetails(int strId) throws CustomException {
		// TODO Auto-generated method stub
		Store strDetails = dao.getStoreDetails(strId);
		return strDetails;
	}

	public ItemsCount getOrderDetails(int strId) throws CustomException {
		// TODO Auto-generated method stub
		ItemsCount itemsCount = dao.getOrderDetails(strId);
		return itemsCount;
		
	}

}
