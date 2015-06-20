package com.angelhack.inka.service;

import com.angelhack.inka.dto.WishDto;

import java.util.List;

/**
 * Created by Askhat_Shagirov on 21-Jun-15.
 */
public interface WishService {

    List<WishDto> getUserWisher(Long currentSellerId);

}
