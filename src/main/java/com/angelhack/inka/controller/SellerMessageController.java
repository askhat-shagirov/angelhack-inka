package com.angelhack.inka.controller;

import com.angelhack.inka.dto.SellerMessageDto;
import com.angelhack.inka.security.SecurityService;
import com.angelhack.inka.service.SellerMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/21/2015.
 */
@RestController
@RequestMapping(value = "/api/seller/message")
public class SellerMessageController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private SellerMessageService sellerMessageService;

    @RequestMapping(method = RequestMethod.GET)
    public List<SellerMessageDto> getMessages() {
        Long sellerId = securityService.getCurrentSeller().getId();
        return sellerMessageService.getMessages(sellerId);
    }
}
