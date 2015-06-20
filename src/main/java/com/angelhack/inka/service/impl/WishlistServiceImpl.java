package com.angelhack.inka.service.impl;

import com.angelhack.inka.entity.ItemEntity;
import com.angelhack.inka.entity.UserEntity;
import com.angelhack.inka.entity.WishlistEntity;
import com.angelhack.inka.exception.ForbiddenException;
import com.angelhack.inka.repository.ItemRepository;
import com.angelhack.inka.repository.UserRepository;
import com.angelhack.inka.repository.WishlistRepository;
import com.angelhack.inka.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */
@Service
@Transactional
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void createWishlist(Long currentUserId, WishlistEntity wishlist) {
        UserEntity user = userRepository.findOne(currentUserId);
        wishlistRepository.saveAndFlush(wishlist);
        user.getWishlists().add(wishlist);
        wishlist.setUser(user);
    }

    @Override
    public List<WishlistEntity> getWishlists(Long currentUserId) {
        UserEntity user = userRepository.findOne(currentUserId);
        return user.getWishlists();
    }

    @Override
    public void addItem(Long currentUserId, Long wishlistId, ItemEntity item) throws ForbiddenException {
        WishlistEntity wishlist = wishlistRepository.findOne(wishlistId);
        if (wishlist.getUser().getId() != currentUserId) {
            throw new ForbiddenException();
        }

        itemRepository.saveAndFlush(item);
        wishlist.getItems().add(item);
        item.setWishlist(wishlist);
    }

    @Override
    public void removeItem(Long currentUserId, Long itemId) throws ForbiddenException {
        ItemEntity item = itemRepository.findOne(itemId);
        if (item.getWishlist().getUser().getId() != currentUserId) {
            throw new ForbiddenException();
        }
    }


}
