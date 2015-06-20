package com.angelhack.inka.service;

import com.angelhack.inka.common.ItemCategory;
import com.angelhack.inka.dto.StoreDto;
import com.angelhack.inka.entity.StoreEntity;

import java.util.List;


public interface StoreService {

    List<StoreEntity> getAll();

    StoreEntity save(StoreEntity test);
    
    List<StoreDto> findNearByStores(double longitude, double latitude,  List<ItemCategory> storeTypes, double radius, String name);
}
