package com.angelhack.inka.dto;

import java.util.ArrayList;
import java.util.List;

import com.angelhack.inka.entity.ItemEntity;

public class StoreSearchResultDto {

	private List<SearchResultWishDto> resultWishDtos;

		
	
	
	public List<SearchResultWishDto> getResultWishDtos() {
		return resultWishDtos;
	}

	public void setResultWishDtos(List<SearchResultWishDto> resultWishDtos) {
		this.resultWishDtos = resultWishDtos;
	}

	public static class SearchResultWishDto{
		private String wishListName;
		private List<SearchResultItemDto> itemDtos;

		public String getWishListName() {
			return wishListName;
		}

		public void setWishListName(String wishListName) {
			this.wishListName = wishListName;
		}

		public List<SearchResultItemDto> getItemDtos() {
			return itemDtos;
		}

		public void setItemDtos(List<SearchResultItemDto> itemDtos) {
			this.itemDtos = itemDtos;
		}				
	}
	
	public static class SearchResultItemDto{
		private String id;
		private String itemName;
		private Long quantity;
		
		public SearchResultItemDto(){}
		
		public SearchResultItemDto(ItemEntity item){
			id = item.getId().toString();
			itemName = item.getName();
			quantity = item.getQuantity();
		}
		
		private List<StoreDto> stores = new ArrayList<StoreDto>(); 
		
		public List<StoreDto> getStores() {
			return stores;
		}

		public void addStores(List<StoreDto> stores) {
			this.stores.addAll(stores);
		}
		
		
		public void addStore(StoreDto store){
			stores.add(store);
		}

		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public Long getQuantity() {
			return quantity;
		}
		public void setQuantity(Long quantity) {
			this.quantity = quantity;
		}
		
		
		
	}
}
