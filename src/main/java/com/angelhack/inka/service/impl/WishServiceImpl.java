package com.angelhack.inka.service.impl;

import com.angelhack.inka.common.ItemCategory;
import com.angelhack.inka.dto.WishDto;
import com.angelhack.inka.entity.ItemEntity;
import com.angelhack.inka.entity.SellerEntity;
import com.angelhack.inka.repository.ItemRepository;
import com.angelhack.inka.repository.SellerRepository;
import com.angelhack.inka.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Askhat_Shagirov on 21-Jun-15.
 */
@Service
@Transactional
public class WishServiceImpl implements WishService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<WishDto> getUserWisher(Long currentSellerId) {
        SellerEntity seller = sellerRepository.findOne(currentSellerId);
        List<ItemCategory> categories = seller.getCategories();
        List<ItemEntity> items = itemRepository.findDistinctByCategoriesInAndBroadcastEquals(categories, true);

        return getWishDtos(items);
    }

    private List<WishDto> getWishDtos(List<ItemEntity> items) {
        List<WishDto> list = new ArrayList<>();
        for(ItemEntity item : items) {
            WishDto wish = new WishDto();
            wish.setItemId(item.getId());
            wish.setName(item.getName());
            wish.setCategories(item.getCategories());
            wish.setQuantity(item.getQuantity());
            list.add(wish);
        }
        return list;
    }
}
