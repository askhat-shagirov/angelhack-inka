package com.angelhack.inka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@RestController
@RequestMapping(value = "api/seller/test")
public class SellerTestController {

    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        return "test";
    }
}
