package com.angelhack.inka.service;

import com.angelhack.inka.dto.SellerMessageDto;

import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/21/2015.
 */
public interface SellerMessageService {

    List<SellerMessageDto> getMessages(long sellerId);
}
