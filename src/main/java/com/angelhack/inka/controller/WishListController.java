package com.angelhack.inka.controller;

import com.angelhack.inka.entity.ItemEntity;
import com.angelhack.inka.entity.WishlistEntity;
import com.angelhack.inka.exception.ForbiddenException;
import com.angelhack.inka.security.SecurityService;
import com.angelhack.inka.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */

@RestController
@RequestMapping(name = "api/user/wishlist")
public class WishListController {

    @Autowired
    private WishlistService wishlistService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(method = RequestMethod.POST)
    public void createWishlist(@RequestBody WishlistEntity wishlist) {
        Long currentUserId = securityService.getCurrentUserId();
        wishlistService.createWishlist(currentUserId, wishlist);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<WishlistEntity> getWishlists() {
        Long currentUserId = securityService.getCurrentUserId();
        return wishlistService.getWishlists(currentUserId);
    }

    @RequestMapping(value = "/{wishlistId}", method = RequestMethod.POST)
    public void addItem(@PathVariable Long wishlistId,
                        @RequestBody ItemEntity item) throws ForbiddenException {
        Long currentUserId = securityService.getCurrentUserId();
        wishlistService.addItem(currentUserId, wishlistId, item);
    }

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.POST)
    public void removeItem(@PathVariable Long itemId) throws ForbiddenException {
        Long currentUserId = securityService.getCurrentUserId();
        wishlistService.removeItem(currentUserId, itemId);
    }


}
