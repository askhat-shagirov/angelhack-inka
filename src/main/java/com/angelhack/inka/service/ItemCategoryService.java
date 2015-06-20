package com.angelhack.inka.service;

import java.util.List;

import com.angelhack.inka.entity.ItemCategoryEntity;


public interface ItemCategoryService {

    List<ItemCategoryEntity> getAll();

    ItemCategoryEntity save(ItemCategoryEntity itemCategoryEntity);
    
    List<ItemCategoryEntity> save(List<ItemCategoryEntity> itemCategoryEntitys) ;
    
    
}
