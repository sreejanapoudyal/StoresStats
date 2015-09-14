package com.nordstrom.hackathon.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderDetails {

	private String name;
	private int assignedItemsCount;
	private int fulfilledItemsCount;
	
	public OrderDetails(){
		
	}
	public OrderDetails(String name, int assignedCount, int fulfilledCount) {
		
		this.name = name;
		this.assignedItemsCount = assignedCount;
		this.fulfilledItemsCount = fulfilledCount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAssignedItemsCount() {
		return assignedItemsCount;
	}
	public void setAssignedItemsCount(int assignedItemsCount) {
		this.assignedItemsCount = assignedItemsCount;
	}
	public int getFulfilledItemsCount() {
		return fulfilledItemsCount;
	}
	public void setFulfilledItemsCount(int fulfilledItemsCount) {
		this.fulfilledItemsCount = fulfilledItemsCount;
	}
	

}
