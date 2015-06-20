package com.angelhack.inka.service;

import java.util.List;

import com.angelhack.inka.dto.StoreSearchResultDto;
import com.angelhack.inka.entity.StoreEntity;


public interface StoreService {

    List<StoreEntity> getAll();

    StoreEntity save(StoreEntity test);
    
    StoreSearchResultDto findNearByStores(double longitude, double latitude, double radius);
}
