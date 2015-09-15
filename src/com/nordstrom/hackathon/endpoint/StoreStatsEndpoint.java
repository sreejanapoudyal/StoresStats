package com.nordstrom.hackathon.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.nordstrom.hackathon.Exception.CustomException;
import com.nordstrom.hackathon.domain.ItemsCount;
import com.nordstrom.hackathon.domain.Store;
import com.nordstrom.hackathon.service.StoreStatsService;

@Path("StoreStatistics")
public class StoreStatsEndpoint {

	StoreStatsService storeService = new StoreStatsService();

	@GET
	@Path("/GetStoreDetails/{strId}")
	@Produces("application/json")
	public Store getStoreDetails(@PathParam("strId") int strId){
		Store storeDetails = new Store();
		try{
			if(strId != 0){
				storeDetails = storeService.getStoreDetails(strId);
				storeDetails.setErrorCode(0);
				storeDetails.setErrorDescription("Success");

			}
		}catch(CustomException e){
			storeDetails.setErrorCode(e.getErrorCode());
			storeDetails.setErrorDescription(e.getErrorDescription());
		}catch (Exception e) {
			storeDetails.setErrorCode(500);
			storeDetails.setErrorDescription(e.getMessage());
		}

		return storeDetails;
	}

	@GET
	@Path("/GetOrderDetails/{strId}")
	@Produces("application/json")
	public ItemsCount getOrderDetails(@PathParam("strId") int strId){
		ItemsCount itemsCount = new ItemsCount();
		try{
			if(strId != 0){
				itemsCount = storeService.getOrderDetails(strId);
				itemsCount.setErrorCode(0);
				itemsCount.setErrorDescription("Success");
			}
		} catch(CustomException e){
			itemsCount.setErrorCode(e.getErrorCode());
			itemsCount.setErrorDescription(e.getErrorDescription());
		}catch (Exception e) {
			itemsCount.setErrorCode(500);
			itemsCount.setErrorDescription(e.getMessage());
		}
		return itemsCount;
	}
}
