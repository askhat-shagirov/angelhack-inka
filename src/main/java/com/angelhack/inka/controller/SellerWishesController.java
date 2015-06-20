package com.angelhack.inka.controller;

import com.angelhack.inka.dto.WishDto;
import com.angelhack.inka.security.SecurityService;
import com.angelhack.inka.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Askhat_Shagirov on 21-Jun-15.
 */
@RestController
@RequestMapping(value = "api/seller/wishes")
public class SellerWishesController {

    @Autowired
    private WishService wishService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(method = RequestMethod.GET)
    public List<WishDto> getUserWisher() {
        return wishService.getUserWisher(securityService.getCurrentSellerId());
    }

}
