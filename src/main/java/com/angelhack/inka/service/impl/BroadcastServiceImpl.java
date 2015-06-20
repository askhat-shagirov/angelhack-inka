package com.angelhack.inka.service.impl;

import com.angelhack.inka.entity.BroadCastEntity;
import com.angelhack.inka.entity.ItemEntity;
import com.angelhack.inka.exception.ForbiddenException;
import com.angelhack.inka.repository.BroadcastRepository;
import com.angelhack.inka.repository.ItemRepository;
import com.angelhack.inka.service.BroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */
@Service
@Transactional
public class BroadcastServiceImpl implements BroadcastService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BroadcastRepository broadcastRepository;

    @Override
    public void broadcastItem(long userId, long itemId, double latitude, double longitude) throws ForbiddenException {
        ItemEntity item = itemRepository.findOne(itemId);

        if (item.getWishlist().getUser().getId() != userId) {
            throw new ForbiddenException();
        }

        BroadCastEntity broadCastEntity = new BroadCastEntity();
        broadCastEntity.setItem(item);
        broadCastEntity.setLatitude(latitude);
        broadCastEntity.setLongitude(longitude);

        broadcastRepository.save(broadCastEntity);
    }
}
