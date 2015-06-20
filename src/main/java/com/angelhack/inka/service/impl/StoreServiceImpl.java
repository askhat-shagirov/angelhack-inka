package com.angelhack.inka.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelhack.inka.common.ItemCategory;
import com.angelhack.inka.dto.StoreDto;
import com.angelhack.inka.dto.StoreSearchResultDto;
import com.angelhack.inka.entity.ItemCategoryEntity;
import com.angelhack.inka.entity.StoreEntity;
import com.angelhack.inka.repository.StoreRepository;
import com.angelhack.inka.service.StoreService;
import com.angelhack.inka.service.google.GooglePlaceService;
import com.angelhack.inka.util.GeoUtil;
import com.angelhack.inka.util.ItemcategoryStoreTypeMap;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;
    
    @Autowired
    private GooglePlaceService googlePlaceService;

    @Override
    public List<StoreEntity> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public StoreEntity save(StoreEntity test) {
        return storeRepository.save(test);
    }
    
    @Override
    public List<StoreDto> findNearByStores(double longitude, double latitude, List<ItemCategory> storeTypes, double radius){
    	List<StoreEntity> stores = storeRepository.findByStoreTypes(storeTypes);
    	System.out.println(stores.size()+" find stores");
    	List<StoreDto> result = new ArrayList<StoreDto>();
    	result.addAll(filterStoresByVicinity(longitude, latitude, radius, stores));
    	result.addAll(googlePlaceService.getStoresNearby(latitude, longitude, radius, storeTypes));
    	return result;
    }
    
    private List<StoreDto> filterStoresByVicinity(double longitude, double latitude, double radius, List<StoreEntity> stores){
    	List<StoreDto> filteredStores = new ArrayList<StoreDto>();
    	double currDist = 0;
    	StoreDto currStoreDTO = null;
    	for(StoreEntity store : stores){
    		currDist = GeoUtil.getDistance(latitude, longitude, store.getLatitude(), store.getLongitude());
    		if(currDist <= radius){
    			currStoreDTO = new StoreDto(store);
    			currStoreDTO.setDistance(currDist);
    			filteredStores.add(currStoreDTO);
    		}
    	}
    	return filteredStores;
    }
    
    public StoreSearchResultDto convert(List<StoreEntity> stores){
    	StoreSearchResultDto searchResultDto = new StoreSearchResultDto();
    	for(StoreEntity store : stores){
    		searchResultDto.addStore(new StoreDto(store));
    	}
    	return searchResultDto;
    }
}