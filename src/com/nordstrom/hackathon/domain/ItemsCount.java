package com.nordstrom.hackathon.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemsCount {

	private int errorCode;
	private String errorDescription;
	
	OrderDetails[] itemCount;

	public ItemsCount(){
		
	}
	
	
	public ItemsCount(int errorCode, String errorDescription,
			OrderDetails[] itemCount) {
		
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.itemCount = itemCount;
	}
	public OrderDetails[] getItemCount() {
		return itemCount;
	}
	public void setItemCount(OrderDetails[] itemCount) {
		this.itemCount = itemCount;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	
	
}
