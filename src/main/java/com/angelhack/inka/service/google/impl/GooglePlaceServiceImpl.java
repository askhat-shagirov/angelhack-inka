package com.angelhack.inka.service.google.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Param;
import se.walkercrou.places.Place;

import com.angelhack.inka.common.ItemCategory;
import com.angelhack.inka.dto.StoreDto;
import com.angelhack.inka.service.google.GooglePlaceService;

@Service
@Transactional
public class GooglePlaceServiceImpl implements GooglePlaceService {

	private static final String API_KEY = "AIzaSyBu_2CEITx1CSkvH2Ew-XjPwDWiUigahRk";
	@Override
	public List<StoreDto> getStoresNearby(double lat, double lon, double radius, List<ItemCategory> storeTypes) {
		GooglePlaces client = new GooglePlaces(API_KEY);
		List<Place> places = client.getNearbyPlaces(lat, lon, radius, GooglePlaces.MAXIMUM_RESULTS, Param.name("types").value(getPlacesTypeSearchtext(storeTypes)));
		
		return convertToStore(places);
	}
	
	private String getPlacesTypeSearchtext(List<ItemCategory> storeTypes){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<storeTypes.size();i++){
			sb.append(storeTypes.get(i).name());
			if(i< (storeTypes.size()-1)) sb.append("|");
		}
		return sb.toString();
	}
	
	private List<StoreDto> convertToStore(List<Place> places){
		List<StoreDto> stores = new ArrayList<StoreDto>();
		StoreDto currStore = null;
		
		for(Place place : places){
			currStore = new StoreDto();
			currStore.setName(place.getName());
			currStore.setLat(place.getLatitude());
			currStore.setLon(place.getLongitude());
			currStore.setAddress(place.getAddress());
			//currStore.setDistance((double)place.getAccuracy());
			currStore.setStoreType(place.getTypes().toString());
			
			stores.add(currStore);
		}
		return stores;
	}

}
