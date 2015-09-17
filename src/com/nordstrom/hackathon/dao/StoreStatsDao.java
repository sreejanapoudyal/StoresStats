package com.nordstrom.hackathon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.nordstrom.hackathon.Exception.CustomException;
import com.nordstrom.hackathon.domain.ItemsCount;
import com.nordstrom.hackathon.domain.OrderDetails;
import com.nordstrom.hackathon.domain.Store;

public class StoreStatsDao {

	private Map<String, String> orderTypeMap = new HashMap<String, String>();


	public StoreStatsDao(){
		orderTypeMap.put("WO", "Web Order Items");
		orderTypeMap.put("ST", "Store Fulfilled Items");
		orderTypeMap.put("BOPUS", "BOPUS Items");
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

	public ItemsCount getOrderDetails(int strId) throws CustomException {
		// TODO Auto-generated method stub
		ItemsCount itemsCount = new ItemsCount();
		OrderDetails orderDetailsArray[] = new OrderDetails[3];
		/*	OrderDetails orderDetails1 = new OrderDetails();
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
		orderDetailsArray[2] = orderDetails3;*/
		//	itemsCount.setItemCount(orderDetailsArray);

		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
			Date today = sdf.parse(sdf.format(new Date()));;
			Class.forName("com.mysql.jdbc.Driver");		  
			con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/nordstromHackathon","root","sreejana"); 
			statement = con.createStatement();
			rs = statement.executeQuery("select RequestType, SUM(IF(ItemState='A',1,0)), SUM(IF(ItemState='F',1,0)) " 
					+ "from ItemDetails where AssignedStore = " + strId + " group by RequestType");
			int count = 0;
			
				while(rs.next()){
					OrderDetails orderDetails = new OrderDetails();
					orderDetails.setName(orderTypeMap.get(rs.getString(1)));
					orderDetails.setAssignedItemsCount(rs.getInt(2));
					orderDetails.setFulfilledItemsCount(rs.getInt(3));
					orderDetailsArray[count] = orderDetails;
					count++;
				}
			

			itemsCount.setItemCount(orderDetailsArray);

		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new CustomException(100, e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new CustomException(200, e.getMessage());
		}  catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new CustomException(1000, e.getMessage());
		}catch (Exception e) {
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

		return itemsCount;
	}

}
