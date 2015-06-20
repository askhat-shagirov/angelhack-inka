package com.angelhack.inka.controller;

import com.angelhack.inka.dto.DiscountDto;
import com.angelhack.inka.security.SecurityService;
import com.angelhack.inka.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Askhat_Shagirov on 21-Jun-15.
 */
@RestController
@RequestMapping(value = "api/seller/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(method = RequestMethod.POST)
    public void saveDiscount(@RequestBody DiscountDto discountDto) {
        Long sellerId = securityService.getCurrentSellerId();
        discountService.createDiscount(sellerId, discountDto);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<DiscountDto> getDiscounts() {
        Long sellerId = securityService.getCurrentSellerId();
        return discountService.getSellerDiscounts(sellerId);
    }
}
