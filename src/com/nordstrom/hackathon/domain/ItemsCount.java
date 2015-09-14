package com.nordstrom.hackathon.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemsCount {

	OrderDetails[] itemCount;

	public ItemsCount(){
		
	}
	public ItemsCount(OrderDetails[] itemCount) {
		
		this.itemCount = itemCount;
	}
	
	public OrderDetails[] getItemCount() {
		return itemCount;
	}
	public void setItemCount(OrderDetails[] itemCount) {
		this.itemCount = itemCount;
	}
	
}
