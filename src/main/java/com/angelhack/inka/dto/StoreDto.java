package com.angelhack.inka.dto;

import java.util.ArrayList;
import java.util.List;

import com.angelhack.inka.entity.StoreEntity;

public class StoreDto {

	private String name;
	private Double lon;
	private Double lat;
	private String address;
	private String storeType;
	//private List<String> categories;
	private List<DiscountDto> discounts = new ArrayList<DiscountDto>();
	//private Double distance;
	
	public StoreDto(){};
	public StoreDto(StoreEntity storeEntity){
		name = storeEntity.getName();
		lon = storeEntity.getLongitude();
		lat = storeEntity.getLatitude();
		storeType = storeEntity.getStoreType().name();
		address = storeEntity.getAddress();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/*public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}*/
	/*public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}*/
	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	public List<DiscountDto> getDiscounts() {
		return discounts;
	}
	public void addDiscounts(DiscountDto discount) {
		this.discounts.add(discount);
	}
	
	
	
}
