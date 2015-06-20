package com.angelhack.inka.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelhack.inka.entity.ItemCategoryEntity;
import com.angelhack.inka.entity.StoreEntity;
import com.angelhack.inka.repository.StoreRepository;
import com.angelhack.inka.service.StoreService;
import com.angelhack.inka.util.GeoUtil;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<StoreEntity> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public StoreEntity save(StoreEntity test) {
        return storeRepository.save(test);
    }
    
    public List<StoreEntity> findNearByStores(double longitude, double latitude, ItemCategoryEntity cat, double vicinityLimit){
    	List<StoreEntity> stores = storeRepository.findBycategory(cat.getName());
    	List<StoreEntity> result = new ArrayList<StoreEntity>();
    	result.addAll(filterStoresByVicinity(longitude, latitude, vicinityLimit, stores));
    	return result;
    }
    
    private List<StoreEntity> filterStoresByVicinity(double longitude, double latitude, double vicinityLimit, List<StoreEntity> stores){
    	List<StoreEntity> filteredStores = new ArrayList<StoreEntity>();
    	double currDist = 0;
    	for(StoreEntity store : stores){
    		currDist = GeoUtil.getDistance(latitude, longitude, store.getLatitude(), store.getLongitude());
    		if(currDist <= vicinityLimit){
    			filteredStores.add(store);
    		}
    	}
    	return filteredStores;
    }
}