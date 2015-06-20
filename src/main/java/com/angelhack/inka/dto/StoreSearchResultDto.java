package com.angelhack.inka.dto;

import java.util.ArrayList;
import java.util.List;

public class StoreSearchResultDto {

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
}
