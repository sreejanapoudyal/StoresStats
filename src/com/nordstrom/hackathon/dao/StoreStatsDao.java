package com.nordstrom.hackathon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nordstrom.hackathon.Exception.CustomException;
import com.nordstrom.hackathon.domain.ItemsCount;
import com.nordstrom.hackathon.domain.OrderDetails;
import com.nordstrom.hackathon.domain.Store;

public class StoreStatsDao {

	public StoreStatsDao(){

	}
	public Store getStoreDetails(int strId) throws CustomException{
		Store storeDetails = new Store();

		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");		  
			con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/nordstromHackathon","root","sreejana"); 
			statement = con.createStatement();
			rs = statement.executeQuery("Select * from StoreDetails where storeId = " + strId);
			if(rs.next()){
				storeDetails.setStoreId(Integer.toString(rs.getInt("storeId")));
				storeDetails.setStoreDesc(rs.getString("storeDesc"));
				storeDetails.setAddressLine1(rs.getString("AddressLine1"));				
				storeDetails.setAddressLine2(rs.getString("AddressLine2"));
				storeDetails.setState(rs.getString("State"));
				storeDetails.setCountry(rs.getString("Country"));
				storeDetails.setPostalCode(rs.getString("PostalCode"));
			}else{
				throw new CustomException(600, "No data returned for given store id");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new CustomException(100, e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new CustomException(200, e.getMessage());
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new CustomException(e.getErrorCode(), e.getErrorDescription());
		}  catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			throw new CustomException(300, e.getMessage());
		}finally{
			try {
				rs.close();
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new CustomException(200, e.getMessage());
			}

		}
		return storeDetails;
	}

	public ItemsCount getOrderDetails(int strId) {
		// TODO Auto-generated method stub
		ItemsCount itemsCount = new ItemsCount();
		OrderDetails orderDetailsArray[] = new OrderDetails[3];
		OrderDetails orderDetails1 = new OrderDetails();
		orderDetails1.setName("StoreFulfilledItems");
		orderDetails1.setAssignedItemsCount(21);
		orderDetails1.setFulfilledItemsCount(22);
		orderDetailsArray[0] = orderDetails1;

		OrderDetails orderDetails2 = new OrderDetails();
		orderDetails2.setName("WebOrderItems");
		orderDetails2.setAssignedItemsCount(21);
		orderDetails2.setFulfilledItemsCount(22);
		orderDetailsArray[1] = orderDetails2;

		OrderDetails orderDetails3 = new OrderDetails();
		orderDetails3.setName("BOPUSItems");
		orderDetails3.setAssignedItemsCount(21);
		orderDetails3.setFulfilledItemsCount(22);
		orderDetailsArray[2] = orderDetails3;

		itemsCount.setItemCount(orderDetailsArray);
		return itemsCount;
	}

}
