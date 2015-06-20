package com.angelhack.inka.service;

import java.util.List;

import com.angelhack.inka.entity.DiscountEntity;


public interface DiscountService {

    List<DiscountEntity> getAll();

    List<DiscountEntity> save(List<DiscountEntity> discounts);
    
    DiscountEntity save(DiscountEntity discount);
    
    List<DiscountEntity>  findDiscountsByItemId(Long itemId);
    
}
