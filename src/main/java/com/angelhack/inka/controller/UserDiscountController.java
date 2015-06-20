package com.angelhack.inka.controller;

import com.angelhack.inka.dto.DiscountDto;
import com.angelhack.inka.security.SecurityService;
import com.angelhack.inka.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Askhat_Shagirov on 21-Jun-15.
 */
@RestController
@RequestMapping(value = "api/user/discount")
public class UserDiscountController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private DiscountService discountService;

    @RequestMapping(method = RequestMethod.GET)
    public List<DiscountDto> getUserDiscounts() {
        Long userId= securityService.getCurrentUserId();
        return discountService.getUserDiscounts(userId);
    }
}
