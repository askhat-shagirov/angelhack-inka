package com.angelhack.inka.service;

import com.angelhack.inka.entity.ItemEntity;
import com.angelhack.inka.entity.WishlistEntity;
import com.angelhack.inka.exception.ForbiddenException;

import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */
public interface WishlistService {

    void createWishlist(Long currentUserId, WishlistEntity wishlist);

    List<WishlistEntity> getWishlists(Long currentUserId);

    void addItem(Long currentUserId, Long wishlistId, ItemEntity item) throws ForbiddenException;

    void removeItem(Long currentUserId, Long itemId) throws ForbiddenException;
}
