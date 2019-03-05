package com.sample.kafka;

public class ItemDetails {
	
	Integer itemId;
	String itemName;
	String itemDescription;
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	@Override
	public String toString() {
		return "ItemDetails [itemId=" + itemId + ", itemName=" + itemName + ", itemDescription=" + itemDescription
				+ "]";
	}
	

}
