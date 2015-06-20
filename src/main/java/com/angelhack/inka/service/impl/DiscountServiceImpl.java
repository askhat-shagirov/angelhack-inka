package com.angelhack.inka.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.angelhack.inka.dto.DiscountDto;
import com.angelhack.inka.entity.ItemEntity;
import com.angelhack.inka.entity.SellerEntity;
import com.angelhack.inka.entity.UserEntity;
import com.angelhack.inka.repository.ItemRepository;
import com.angelhack.inka.repository.SellerRepository;
import com.angelhack.inka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelhack.inka.entity.DiscountEntity;
import com.angelhack.inka.repository.DiscountRepository;
import com.angelhack.inka.service.DiscountService;
import org.springframework.util.CollectionUtils;

@Service
@Transactional
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<DiscountDto> getSellerDiscounts(Long sellerId) {
        SellerEntity seller = sellerRepository.findOne(sellerId);
        List<DiscountEntity> entities = seller.getDiscounts();
        return getDiscountDtoList(entities);
    }

    @Override
    public DiscountEntity createDiscount(Long sellerId, DiscountDto discount) {
        DiscountEntity entity = new DiscountEntity();
        entity.setName(discount.getName());
        entity.setDiscountedPrice(discount.getDiscountedPrice());
        entity.setPrice(discount.getPrice());
        discountRepository.save(entity);
        ItemEntity item = itemRepository.findOne(discount.getItemId());
        entity.setItem(item);
        item.getDiscounts().add(entity);
        SellerEntity seller = sellerRepository.findOne(sellerId);
        entity.setSeller(seller);
        item.getDiscounts().add(entity);
        return entity;
    }

    @Override
    public List<DiscountEntity> findDiscountsByItemId(Long itemId) {
        ItemEntity item = itemRepository.findOne(itemId);
        return item.getDiscounts();
    }

    @Override
    public List<DiscountDto> getUserDiscounts(Long userId) {
        UserEntity user = userRepository.findOne(userId);
        List<ItemEntity> items = user.getItems();

        List<DiscountEntity> result = new ArrayList<>();
        for(ItemEntity item : items) {
            if(CollectionUtils.isEmpty(item.getDiscounts())) continue;
            result.addAll(item.getDiscounts());
        }
        return getDiscountDtoList(result);
    }

    public List<DiscountDto> getDiscountDtoList(List<DiscountEntity> entities) {
        List<DiscountDto> result = new ArrayList<>();
        for (DiscountEntity entity : entities) {
            DiscountDto dto = new DiscountDto();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setDiscountedPrice(entity.getDiscountedPrice());
            dto.setItemId(entity.getItem().getId());
            result.add(dto);
        }
        return result;
    }

}
