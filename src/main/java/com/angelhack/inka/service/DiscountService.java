package com.angelhack.inka.service;

import java.util.List;

import com.angelhack.inka.dto.DiscountDto;
import com.angelhack.inka.entity.DiscountEntity;


public interface DiscountService {

    List<DiscountDto> getSellerDiscounts(Long sellerId);

    DiscountEntity createDiscount(Long sellerId, DiscountDto discount);

    List<DiscountEntity> findDiscountsByItemId(Long itemId);

    List<DiscountDto> getUserDiscounts(Long userId);
}
