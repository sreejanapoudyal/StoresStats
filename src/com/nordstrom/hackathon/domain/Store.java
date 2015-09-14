package com.nordstrom.hackathon.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Store {

	private String storeId;
	private String storeDesc;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String country;
	private String postalCode;
	private int errorCode;
	private String errorDescription;
	
	public Store(){
		
	}
	
	
	public Store(String storeId, String storeDesc, String addressLine1,
			String addressLine2, String state, String country,
			String postalCode, int errorCode, String errorDescription) {
	
		this.storeId = storeId;
		this.storeDesc = storeDesc;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreDesc() {
		return storeDesc;
	}
	public void setStoreDesc(String storeDesc) {
		this.storeDesc = storeDesc;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String strAddressLine1) {
		this.addressLine1 = strAddressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String strAddressLine2) {
		this.addressLine2 = strAddressLine2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
