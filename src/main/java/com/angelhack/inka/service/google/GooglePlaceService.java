package com.angelhack.inka.service.google;

import java.util.List;

import com.angelhack.inka.common.ItemCategory;
import com.angelhack.inka.dto.StoreDto;


public interface GooglePlaceService {

	public List<StoreDto> getStoresNearby(double lat, double lon, double radius, List<ItemCategory> storeTypes);
}
