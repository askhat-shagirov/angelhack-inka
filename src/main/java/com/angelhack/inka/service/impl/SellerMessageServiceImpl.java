package com.angelhack.inka.service.impl;

import com.angelhack.inka.dto.SellerMessageDto;
import com.angelhack.inka.entity.ItemEntity;
import com.angelhack.inka.entity.SellerEntity;
import com.angelhack.inka.repository.ItemRepository;
import com.angelhack.inka.repository.SellerRepository;
import com.angelhack.inka.service.SellerMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/21/2015.
 */
@Service
@Transactional
public class SellerMessageServiceImpl implements SellerMessageService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<SellerMessageDto> getMessages(long sellerId) {
        SellerEntity seller = sellerRepository.findOne(sellerId);

        List<ItemEntity> items = itemRepository.findWhereCategoryInAndBroadcastEnabled(seller.getCategories());

        List<SellerMessageDto> messageDtos = new ArrayList<>();

        for (ItemEntity item : items) {
            SellerMessageDto message = new SellerMessageDto();
            message.setId(item.getId());
            message.setName(item.getName());
            message.setDescription(item.getDescription());
            messageDtos.add(message);
        }

        return messageDtos;
    }
}
