package com.angelhack.inka.service;

import com.angelhack.inka.entity.StoreEntity;

import java.util.List;


public interface StoreService {

    List<StoreEntity> getAll();

    StoreEntity save(StoreEntity test);
    
    
}
