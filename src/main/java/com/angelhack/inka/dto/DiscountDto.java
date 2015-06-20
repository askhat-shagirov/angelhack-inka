package com.angelhack.inka.dto;

import com.angelhack.inka.entity.DiscountEntity;

public class DiscountDto {

	private String itemName;
	private double actualPrice;
	private double discountPrice;
	
	public DiscountDto(){}
	
	public DiscountDto(DiscountEntity disc){
		itemName = disc.getName();
		actualPrice = disc.getPrice();
		discountPrice = disc.getDiscountedPrice();		
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(double actualPrice) {
		this.actualPrice = actualPrice;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	
	
	
	
}
